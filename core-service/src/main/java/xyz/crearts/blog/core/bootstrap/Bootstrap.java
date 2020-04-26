package xyz.crearts.blog.core.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import xyz.crearts.blog.core.r2dbc.repository.MimeTypeRepository;

import javax.annotation.Resource;

@Component
public class Bootstrap implements CommandLineRunner {
    @Resource
    private MimeTypeRepository mimeTypeRepository;
    @Override
    public void run(String... args)  {
        mimeTypeRepository.findAll().log().subscribe();
    }
}
