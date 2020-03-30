package xyz.crearts.blog.core.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import xyz.crearts.blog.core.service.WebCamService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.function.Consumer;

/**
 * @author ivan.kishchenko
 */
@RequestMapping("/webcam")
@RestController
@AllArgsConstructor
@Slf4j
public class WebCamController {
    private final WebCamService webCamService;

    @GetMapping(value = "/live", produces = "multipart/x-mixed-replace; boundary=__image__")
    public Flux<byte[]> liveStream() {
        return Flux.create(sink -> {
            Consumer<byte[]> callback = rawImage -> {
                try {
                    final ByteArrayOutputStream result = new ByteArrayOutputStream();
                    String builder = "--__image__\r\n" +
                            "Content-Type: image/jpeg\r\n" +
                            "Content-Length: " + rawImage.length + "\r\n\r\n";

                    result.writeBytes(builder.getBytes());
                    result.write(rawImage);
                    result.write("\r\n--__image__\r\n".getBytes());
                    sink.next(result.toByteArray());
                } catch (IOException ioe) {
                    throw new UncheckedIOException(ioe);
                }
            };

            webCamService.subscribe(callback);
            sink.onDispose(() -> {
                log.info("Thread {} cancel connection", Thread.currentThread().getName());
                webCamService.unsubscribe(callback);
            });
        });
    }
}
