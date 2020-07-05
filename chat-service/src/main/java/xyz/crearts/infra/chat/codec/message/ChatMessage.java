package xyz.crearts.infra.chat.codec.message;

import lombok.Getter;
import lombok.Setter;
import xyz.crearts.infra.chat.codec.ChatMessageConst;
import xyz.crearts.infra.chat.codec.ChatMessageId;

@Getter
@Setter
public class ChatMessage {
    private int magic = ChatMessageConst.CHAT_MSG_MAGIC;
    private ChatMessageId msgId;
}
