package xyz.crearts.blog.admin.controller.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.crearts.blog.admin.jpa.model.Content_;
import xyz.crearts.blog.admin.jpa.repository.ContentRepository;
import xyz.crearts.blog.admin.mapper.ContentMapper;
import xyz.crearts.blog.dto.ContentDTO;
import xyz.crearts.blog.enums.ContentType;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticlesController {
    private final ContentMapper contentMapper;
    private final ContentRepository contentRepository;

    @GetMapping(value = "page", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<ContentDTO> page(Pageable pageable) {
        return contentMapper.page(contentRepository.findAll((root, query, builder) -> {
                    return builder.and(
                            root.get(Content_.TYPE).in(ContentType.CT_ARTICLE)
                    );
                }, pageable)
        );
    }
}
