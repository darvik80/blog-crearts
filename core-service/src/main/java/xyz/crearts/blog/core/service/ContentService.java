package xyz.crearts.blog.core.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import xyz.crearts.blog.core.dto.ContentDTO;
import xyz.crearts.blog.core.dto.LightContentDTO;
import xyz.crearts.blog.core.mapper.ContentMapper;
import xyz.crearts.blog.core.r2dbc.repository.ContentRepository;

@Service
public class ContentService {
    private final ContentRepository contentRepository;

    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public Mono<ContentDTO> getContent(long id) {
        return contentRepository.getContent(id)
                .map(ContentMapper.INSTANCE::do2dto);
    }

    public Flux<LightContentDTO> getContentPage(PageRequest page) {
        return contentRepository.getContentPage(page.getOffset(), page.getPageSize())
                .log().map(ContentMapper.INSTANCE::do2dto);
    }
}
