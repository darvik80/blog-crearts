package xyz.crearts.infra.chat.codec.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessageText extends ChatMessage {
    private String text;
}
