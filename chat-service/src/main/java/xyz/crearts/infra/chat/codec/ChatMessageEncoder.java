package xyz.crearts.infra.chat.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import xyz.crearts.infra.chat.codec.message.ChatMessage;
import xyz.crearts.infra.chat.codec.message.ChatMessageLogin;
import xyz.crearts.infra.chat.codec.message.ChatMessageResult;
import xyz.crearts.infra.chat.codec.message.ChatMessageText;
import xyz.crearts.infra.chat.exception.ChatMessageCode;
import xyz.crearts.infra.chat.exception.ChatMessageException;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class ChatMessageEncoder extends MessageToByteEncoder<ChatMessage> {
    private final Map<ChatMessageId, BiFunction<ChatMessage, ByteBuf, ByteBuf>> encoders = new HashMap<>();
    private final BiFunction<ChatMessage, ByteBuf, ByteBuf> defaultEncoder = (msg, byteBuf) -> {
        throw new ChatMessageException(ChatMessageCode.CHAT_MSG_CODE_INVALID_MSG_ID);
    };

    public ChatMessageEncoder() {
        this.encoders.put(ChatMessageId.CHAT_MSG_LOGIN, this::encodeChatMsgLogin);
        this.encoders.put(ChatMessageId.CHAT_MSG_TEXT, this::encodeChatMsgText);
        this.encoders.put(ChatMessageId.CHAT_MSG_RESULT, this::encodeChatMsgResult);
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, ChatMessage msg, ByteBuf byteBuf) {
        this.encoders.getOrDefault(msg.getMsgId(), defaultEncoder).apply(msg, byteBuf);
    }

    private void encodeChatMsg(ChatMessage msg, ByteBuf byteBuf) {
        byteBuf.writeShort(msg.getMagic());
        byteBuf.writeShort(msg.getMsgId().ordinal());
    }

    private static ByteBuf encodeString(String text, ByteBuf byteBuf) {
        var data = text.getBytes();
        byteBuf.writeShort(data.length);
        return byteBuf.writeBytes(text.getBytes());
    }

    private ByteBuf encodeChatMsgLogin(ChatMessage msg, ByteBuf byteBuf) {
        encodeChatMsg(msg, byteBuf);
        ChatMessageLogin login = (ChatMessageLogin)msg;
        encodeString(login.getUsername(), byteBuf);
        return encodeString(login.getPassword(), byteBuf);
    }

    private ByteBuf encodeChatMsgText(ChatMessage msg, ByteBuf byteBuf) {
        encodeChatMsg(msg, byteBuf);
        ChatMessageText msgText = (ChatMessageText)msg;
        return encodeString(msgText.getText(), byteBuf);
    }

    private ByteBuf encodeChatMsgResult(ChatMessage msg, ByteBuf byteBuf) {
        encodeChatMsg(msg, byteBuf);
        ChatMessageResult res = (ChatMessageResult)msg;
        byteBuf.writeShort(res.getCode());
        encodeString(res.getMessage(), byteBuf);
        byteBuf.writeByte(res.getExtraData().size());
        res.getExtraData().forEach((k, v) -> {
            encodeString(k, byteBuf);
            if (v instanceof String) {
                byteBuf.writeByte(ChatMessageObjectType.CHAT_MSG_OBJ_TYPE_STRING.ordinal());
                encodeString(k, byteBuf);
            } else if (v instanceof Long) {
                byteBuf.writeByte(ChatMessageObjectType.CHAT_MSG_OBJ_TYPE_LONG.ordinal());
                byteBuf.writeLong((Long)v);
            } else {
                throw new ChatMessageException(ChatMessageCode.CHAT_MSG_CODE_UNSUPPORTED_TYPE, v.getClass().getName());
            }
        });

        return byteBuf;
    }
}
