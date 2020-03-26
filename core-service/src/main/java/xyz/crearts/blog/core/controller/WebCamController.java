package xyz.crearts.blog.core.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import xyz.crearts.blog.core.service.WebCamService;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;

/**
 * @author ivan.kishchenko
 */
@RequestMapping("/webcam")
@RestController
@AllArgsConstructor
public class WebCamController {
    private final WebCamService webCamService;

    @GetMapping(value = "/live", produces = "multipart/x-mixed-replace; boundary=__image__")
    public Flux<byte[]> liveStream() {
        return Flux.create(sink -> {
            webCamService.subscribe((item) -> {
                final ByteArrayOutputStream result = new ByteArrayOutputStream();

                final ByteArrayOutputStream os = new ByteArrayOutputStream();
                try
                {
                    ImageIO.write(item, "JPEG", os);


                    String builder = "--__image__\r\n" +
                            "Content-Type: image/jpeg\r\n" +
                            "Content-Length: " + os.size() + "\r\n\r\n";

                    result.writeBytes(builder.getBytes());
                    result.write(os.toByteArray());
                    result.write("\r\n--__image__\r\n".getBytes());

                    sink.next(result.toByteArray());
                }
                catch (final IOException ioe)
                {
                    throw new UncheckedIOException(ioe);
                }
            });
        });
    }
}
