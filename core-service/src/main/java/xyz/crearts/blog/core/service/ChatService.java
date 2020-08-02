package xyz.crearts.blog.core.service;

import org.springframework.stereotype.Service;
import xyz.crearts.infra.chat.configuration.ChatServerProperties;
import xyz.crearts.infra.chat.service.ChatMessageServer;

@Service
public class ChatService {
    private final ChatMessageServer chatMessageServer;

    public ChatService() {
        chatMessageServer = new ChatMessageServer(ChatServerProperties.builder().port(10000).build());
    }
}
