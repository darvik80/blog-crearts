package xyz.crearts.blog.admin.article.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.crearts.blog.admin.article.mapper.ContentMapper;
import xyz.crearts.blog.admin.article.service.ArticleService;
import xyz.crearts.blog.admin.controller.api.CrudController;
import xyz.crearts.blog.admin.jpa.model.Content;
import xyz.crearts.blog.dto.ContentDTO;
import xyz.crearts.blog.enums.ContentStatus;

@RestController
@RequestMapping("/api/articles")
public class ArticlesController extends CrudController<Content, ContentDTO> {
    public ArticlesController(ArticleService service, ContentMapper contentMapper) {
        super(service, contentMapper);
    }

    @PostMapping(value = "/publish", produces = MediaType.APPLICATION_JSON_VALUE)
    public void publishItem(@RequestParam Long id) {
        getService().getItem(id).ifPresent(item -> {
            item.setStatus(ContentStatus.CS_PUBLISHED);
            getService().updateItem(id, item);
        });
    }
}
