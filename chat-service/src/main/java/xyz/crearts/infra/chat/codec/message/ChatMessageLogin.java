package xyz.crearts.infra.chat.codec.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessageLogin extends ChatMessage {
    private String username;
    private String password;
}
