package xyz.crearts.infra.chat.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import xyz.crearts.infra.chat.codec.message.ChatMessage;
import xyz.crearts.infra.chat.codec.message.ChatMessageLogin;
import xyz.crearts.infra.chat.codec.message.ChatMessageResult;
import xyz.crearts.infra.chat.codec.message.ChatMessageText;
import xyz.crearts.infra.chat.exception.ChatMessageCode;
import xyz.crearts.infra.chat.exception.ChatMessageException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ChatMessageDecoder extends ReplayingDecoder<ChatMessage> {
    private Map<Integer, Function<ByteBuf, ChatMessage>> decoders = new HashMap<>();
    private Function<ByteBuf, ChatMessage> defaultDecoder = byteBuf -> {
        throw new ChatMessageException(ChatMessageCode.CHAT_MSG_CODE_INVALID_MSG_ID);
    };

    public ChatMessageDecoder() {
        decoders.put(ChatMessageId.CHAT_MSG_LOGIN.ordinal(), this::decoderChatMsgLogin);
        decoders.put(ChatMessageId.CHAT_MSG_TEXT.ordinal(), this::decoderChatMsgText);
        decoders.put(ChatMessageId.CHAT_MSG_RESULT.ordinal(), this::decoderChatMsgResult);
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        int magic = byteBuf.getShort(0);
        int msgId = byteBuf.getShort(2);

        if (magic != ChatMessageConst.CHAT_MSG_MAGIC) {
            throw new ChatMessageException(ChatMessageCode.CHAT_MSG_CODE_INVALID_MSG_MAGIC);
        }

        list.add(decoders.getOrDefault(msgId, defaultDecoder).apply(byteBuf));
    }

    private void decodeFixedHeader(ByteBuf buf, ChatMessage msg) {
        msg.setMagic(buf.readShort());
        msg.setMagic(buf.readShort());
    }

    private String decodeString(ByteBuf buf) {
        byte[] data = new byte[buf.readShort()];
        buf.readBytes(data);

        return new String(data);
    }

    private ChatMessage decoderChatMsgLogin(ByteBuf buf) {
        ChatMessageLogin login = new ChatMessageLogin();
        decodeFixedHeader(buf, login);
        login.setUsername(decodeString(buf));
        login.setPassword(decodeString(buf));

        return login;
    }

    private ChatMessage decoderChatMsgText(ByteBuf buf) {
        ChatMessageText text = new ChatMessageText();
        decodeFixedHeader(buf, text);
        text.setText(decodeString(buf));

        return text;
    }

    private ChatMessage decoderChatMsgResult(ByteBuf buf) {
        ChatMessageResult res = new ChatMessageResult();
        decodeFixedHeader(buf, res);
        res.setCode(buf.readShort());
        res.setMessage(decodeString(buf));
        int count = buf.readByte();
        for (int idx = 0; idx < count; idx++) {
            var key = decodeString(buf);
            var type = ChatMessageObjectType.values()[buf.readByte()];

            Object value;
            if (type == ChatMessageObjectType.CHAT_MSG_OBJ_TYPE_STRING) {
                value = decodeString(buf);
            } else if (type == ChatMessageObjectType.CHAT_MSG_OBJ_TYPE_LONG) {
                value = buf.readLong();
            } else {
                throw new ChatMessageException(ChatMessageCode.CHAT_MSG_CODE_UNSUPPORTED_TYPE);
            }

            res.setExtra(key, value);
        }

        return res;
    }
}

