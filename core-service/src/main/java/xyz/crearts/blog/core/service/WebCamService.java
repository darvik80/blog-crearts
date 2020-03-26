package xyz.crearts.blog.core.service;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamEvent;
import com.github.sarxos.webcam.WebcamListener;
import com.github.sarxos.webcam.WebcamResolution;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

/**
 * @author ivan.kishchenko
 */
@Slf4j
@Service
public class WebCamService implements WebcamListener {
    public final static String DEFAULT_CAMERA = "default";
    private final Webcam webcam;

    private BufferedImage lastImage = null;
    private Set<Consumer<BufferedImage>> consumers = new HashSet<>();

    public WebCamService(@Value("${spring.webcam.name:default}") final String camName) {
        this.webcam = DEFAULT_CAMERA.compareToIgnoreCase(camName) == 0 ? Webcam.getDefault() : Webcam.getWebcamByName(camName);
    }

    public void start() {
        if (!webcam.isOpen()) {
            webcam.setViewSize(WebcamResolution.VGA.getSize());
            webcam.addWebcamListener(this);
            webcam.open(true);
        }
    }

    public void stop() {
        if (webcam.isOpen()) {
            webcam.close();
        }
    }

    public synchronized void subscribe(Consumer<BufferedImage> consumer) {
        if (consumers.size() == 0) {
            start();
        }
        consumers.add(consumer);
    }

    public synchronized void unsubscribe(Consumer<BufferedImage> consumer) {
        consumers.remove(consumer);

        if (consumers.size() == 0) {
            stop();
        }
    }

    @Override
    public void webcamOpen(WebcamEvent we) {
        log.info("Camera available {}", we.getSource().getDevice().getName());
    }

    @Override
    public void webcamClosed(WebcamEvent we) {
        log.info("Camera closed {}", we.getSource().getDevice().getName());
    }

    @Override
    public void webcamDisposed(WebcamEvent we) {
        log.info("Camera image disposed {}", we.getSource().getDevice().getName());
    }

    @Override
    public synchronized void webcamImageObtained(WebcamEvent we) {
        consumers.forEach(consumer -> {
            consumer.accept(we.getImage());
        });
    }
}
