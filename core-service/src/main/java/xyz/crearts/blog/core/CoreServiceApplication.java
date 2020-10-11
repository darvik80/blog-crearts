package xyz.crearts.blog.core;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.util.ReflectionUtils;
import xyz.crearts.blog.core.api.MainService;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@EnableDiscoveryClient
@EnableR2dbcRepositories(basePackages = "xyz.crearts.blog.core.r2dbc")
@SpringBootApplication
public class CoreServiceApplication {
    @Autowired
    private MainService service;

    @PostConstruct
    public void postConstruct() {
        var proxy = Proxy.newProxyInstance
                (
                        MainService.class.getClassLoader(),
                        new Class[]{MainService.class},
                        (proxy1, method, args) -> ReflectionUtils.invokeMethod(method, service, args)
                );

        var res = MainService.class.isAssignableFrom(proxy.getClass());
        System.out.println(res);
    }

    public static void main(String[] args) {
        SpringApplication.run(CoreServiceApplication.class, args);
    }

}
