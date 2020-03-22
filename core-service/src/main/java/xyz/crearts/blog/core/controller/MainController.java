package xyz.crearts.blog.core.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/config")
@RefreshScope
public class MainController {

    @Value("${message:test}")
    private String message;

    @RequestMapping("/message")
    public Mono<String> getMessage() {
        return Mono.just(message);
    }
}
