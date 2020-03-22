package xyz.crearts.blog.discovery.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*
        it's help you to solve conflict between discovery & config services

         */
        registry
                .addResourceHandler("/eureka/**")
                .addResourceLocations("/eureka/","classpath:/static/eureka/");
    }
}

