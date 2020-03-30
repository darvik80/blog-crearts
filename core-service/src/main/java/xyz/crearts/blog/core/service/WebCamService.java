package xyz.crearts.blog.core.service;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamEvent;
import com.github.sarxos.webcam.WebcamListener;
import com.github.sarxos.webcam.WebcamResolution;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;

/**
 * @author ivan.kishchenko
 */
@Slf4j
@Service
public class WebCamService implements WebcamListener, Runnable {
    public final static String DEFAULT_CAMERA = "default";
    private final Webcam webcam;

    private Set<Consumer<byte[]>> consumers = new HashSet<>();

    enum Command {
        Quit,
        Start,
        Stop
    }
    final private BlockingQueue<Command> commandQueue = new LinkedBlockingQueue<>();
    final Thread threadCtrl;

    public WebCamService(@Value("${spring.webcam.name:default}") final String camName) {
        this.webcam = DEFAULT_CAMERA.compareToIgnoreCase(camName) == 0 ? Webcam.getDefault() : Webcam.getWebcamByName(camName);
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        webcam.addWebcamListener(this);

        threadCtrl = new Thread(this);
        threadCtrl.start();
    }

    @PreDestroy
    public void preDestroy() throws InterruptedException {
        threadCtrl.interrupt();
        threadCtrl.join();
    }

    public synchronized void subscribe(Consumer<byte[]> consumer) {
        if (consumers.size() == 0) {
            commandQueue.add(Command.Start);
        }
        consumers.add(consumer);
    }

    public synchronized void unsubscribe(Consumer<byte[]> consumer) {
        consumers.remove(consumer);

        if (consumers.size() == 0) {
            commandQueue.add(Command.Stop);
        }
    }

    @Override
    public void webcamOpen(WebcamEvent we) {
        log.info("Thread {} Camera available {}", Thread.currentThread().getName(), we.getSource().getDevice().getName());
    }

    @Override
    public void webcamClosed(WebcamEvent we) {
        log.info("Thread {} Camera closed {}", Thread.currentThread().getName(), we.getSource().getDevice().getName());
    }

    @Override
    public void webcamDisposed(WebcamEvent we) {
        log.info("Thread {} Camera image disposed {}", Thread.currentThread().getName(), we.getSource().getDevice().getName());
    }

    @Override
    public synchronized void webcamImageObtained(WebcamEvent we) {
        final ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ImageIO.write(we.getImage(), "JPEG", os);
            var rawImage = os.toByteArray();
            consumers.forEach(consumer -> {
                consumer.accept(rawImage);
            });
        } catch (final IOException ioe) {
            throw new UncheckedIOException(ioe);
        }
    }

    @Override
    public void run() {
        log.info("Start control thread");
        try {
            while (true) {
                switch (commandQueue.take()) {
                    case Start:
                        if (!webcam.isOpen()) {
                            webcam.open(true);
                        }
                        break;
                    case Stop:
                        if (webcam.isOpen()) {
                            webcam.close();
                        }
                        break;
                    default:
                        return;
                }
            }
        } catch (InterruptedException ignore) {
            log.info("Stop control thread");
        }
    }
}
