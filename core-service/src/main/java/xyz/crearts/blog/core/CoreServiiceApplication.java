package xyz.crearts.blog.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CoreServiiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoreServiiceApplication.class, args);
    }

}
