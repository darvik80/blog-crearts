package xyz.crearts.blog.core.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import xyz.crearts.blog.core.mapper.ContentMapper;
import xyz.crearts.blog.dto.ContentDTO;
import xyz.crearts.blog.jpa.repository.ContentRepository;

import java.util.Optional;

@Service
public class ContentService {
    private final ContentRepository contentRepository;

    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public Optional<ContentDTO> getContent(long id) {
        return contentRepository.findById(id)
                .map(ContentMapper.INSTANCE::do2dto);
    }

    public Page<ContentDTO> getContentPage(PageRequest page) {
        return contentRepository.findAll((root, query, builder) -> null, page)
                .map(ContentMapper.INSTANCE::do2dto);
    }
}
