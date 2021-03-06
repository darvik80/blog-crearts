rd[![Build Status](https://api.travis-ci.org/darvik80/blog-crearts.svg?branch=master)](https://travis-ci.org/darvik80/blog-crearts)
[![](https://jitpack.io/v/darvik80/blog-crearts.svg)](https://jitpack.io/#darvik80/blog-crearts)

# blog-crearts
Blog service for crearts.xyz hosted on Rapsberry PI nodes 

### infra-service
Contains spring-cloud-discovery & spring-cloud-config

### core-frontend
UI based on React-JS app

### core-service
Reactive Blog Service for blog.crearts.xyz

## Issues & Solutions
### Config first time call http://localhost:8888
move settings to bootstrap.properties

### Conflict discovery vs config 
- fix application.properties: spring.cloud.config.server.prefix=/config
- fix web-config:
```java
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
```

### Config: RefreshScope
```shell script
curl -XPOST -d {} http://localhost:7004/actuator/refresh -i -H "content-type: application/json"
```

### Not work default redirect from ‘/‘ to index.html
[solution](https://stackoverflow.com/questions/45147280/spring-webflux-how-to-forward-to-index-html-to-serve-static-content)
        
        
# Setup Env for Dev
## DNS 
Add lines into /etc/hosts
```shell script
127.0.0.1 discovery.local
127.0.0.1 config.local
127.0.0.1 mysql.local
127.0.0.1 mongodb.local
127.0.0.1 rabbitmq.local
```        
or exec dns.sh
