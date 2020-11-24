package xyz.crearts.blog.core.controller;

import io.micrometer.core.instrument.FunctionCounter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/config")
@RefreshScope
public class MainController {

    @Value("${message:test}")
    private String message;

    private final MeterRegistry registry;

    private AtomicInteger cnt = new AtomicInteger();
    private final FunctionCounter counter;

    public MainController(MeterRegistry registry) {
        this.registry = registry;

        this.counter = FunctionCounter
                .builder("counter", cnt, AtomicInteger::get)
                .baseUnit("request") // optional
                .description("a description of what this counter does") // optional
                .tags("region", "test") // optional
                .register(registry);
    }

    @RequestMapping("/message")
    public String getMessage() {
        var counter = registry.counter("test", "tag", "hello");
        counter.increment();

        cnt.getAndIncrement();
        return "Hello";
    }
}
