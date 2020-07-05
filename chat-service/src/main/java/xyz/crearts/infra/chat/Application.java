package xyz.crearts.infra.chat;

import xyz.crearts.infra.chat.configuration.ChatServerProperties;
import xyz.crearts.infra.chat.service.ChatMessageServer;

public class Application {
    public static void main(String[] args) throws Exception {
        var server = new ChatMessageServer(ChatServerProperties.builder().port(7001).build());

        server.run();
    }
}
