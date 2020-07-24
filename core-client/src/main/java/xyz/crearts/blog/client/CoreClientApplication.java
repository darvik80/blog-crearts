package xyz.crearts.blog.client;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import xyz.crearts.blog.core.api.MainService;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableScheduling
public class CoreClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreClientApplication.class, args);
    }

    @Reference(protocol = "dubbo", version = "1.0.0", check = false, lazy = true)
    MainService mainService;

    @Scheduled(fixedRate = 10000)
    public void onScheduler() {
        System.out.println(mainService.name());
    }
}
