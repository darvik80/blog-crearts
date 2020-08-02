package xyz.crearts.infra.chat.configuration;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatServerProperties {
    @Builder.Default
    private int port = 7001;
}
