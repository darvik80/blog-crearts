package xyz.crearts.blog.core.facade;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Service;
import xyz.crearts.blog.core.api.MainService;

@Slf4j
@Service(version = "1.0.0", protocol = "dubbo")
public class MainServiceDubbo implements MainService {
    public MainServiceDubbo() {
        log.info("Create MainServiceDubbo");
    }

    @Override
    public String name() {
        return "Core-Service";
    }
}
