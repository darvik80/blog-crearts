package xyz.crearts.blog.core.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Disabled
class ContentServiceTest {
    @Autowired
    private ContentService service;

    @Test
    void getContent() {
        var data = service.getContent(1);

        System.out.println(data.block().getId());
    }

    @Test
    void getContentPage() {
        var data = service.getContentPage(PageRequest.of(0, 10));

        data.log().subscribe(item -> {
            System.out.println(item.getId());
        });
    }
}