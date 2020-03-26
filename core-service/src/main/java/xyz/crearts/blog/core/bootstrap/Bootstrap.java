package xyz.crearts.blog.core.bootstrap;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamEvent;
import com.github.sarxos.webcam.WebcamListener;
import com.github.sarxos.webcam.WebcamResolution;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.awt.image.BufferedImage;


/**
 * @author ivan.kishchenko
 */
@Slf4j
//@Component
public class Bootstrap implements CommandLineRunner {
    private Webcam webcam = Webcam.getDefault();
    private ConnectableFlux<BufferedImage> imageStream;

    @PostConstruct
    public void postConstruct() {
        Flux<BufferedImage> stream = Flux.create(sink -> {
            webcam.addWebcamListener(new WebcamListener() {
                @Override
                public void webcamOpen(WebcamEvent we) {
                    log.info("Camera available {}", we.getSource().getDevice().getName());
                }

                @Override
                public void webcamClosed(WebcamEvent we) {
                    log.info("Camera closed {}", we.getSource().getDevice().getName());
                    sink.complete();
                }

                @Override
                public void webcamDisposed(WebcamEvent we) {
                    //log.info("Image disposed {}", we.getSource().getDevice().getName());
                }

                @Override
                public void webcamImageObtained(WebcamEvent we) {
                    //log.info("Image obtained {}", we.getSource().getDevice().getName());
                    sink.next(we.getImage());

                }
            });

            webcam.setViewSize(WebcamResolution.VGA.getSize());
            webcam.open(true);
        });
        imageStream = stream.publish();
        imageStream.connect();
        imageStream.subscribe(this::onNext);
    }

    @PreDestroy
    public void preDestroy() {
        if (webcam.isOpen()) {
            webcam.close();
        }
    }

    @Override
    public void run(String... args) throws InterruptedException {
        imageStream.subscribe(this::onNext);
    }

    public void onNext(BufferedImage image) {
        log.info("Handle Image");
    }
}
