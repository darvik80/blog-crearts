package xyz.crearts.blog.jpa.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@Configuration
@EnableJpaRepositories("xyz.crearts.blog.jpa.repository")
@EntityScan("xyz.crearts.blog.jpa.entity")
public class JpaConfiguration {
    @PostConstruct
    public void postConstruct() {
        System.out.println(JpaConfiguration.class.getCanonicalName());
    }
}
