package xyz.crearts.blog.admin.article.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import xyz.crearts.blog.admin.service.CrudService;
import xyz.crearts.blog.admin.service.TagService;
import xyz.crearts.blog.jpa.entity.Content;
import xyz.crearts.blog.jpa.entity.Content_;
import xyz.crearts.blog.jpa.entity.Tag;
import xyz.crearts.blog.jpa.enums.ContentStatus;
import xyz.crearts.blog.jpa.enums.ContentType;
import xyz.crearts.blog.jpa.repository.ContentRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService implements CrudService<Content, String> {
    private final ContentRepository repository;
    private final TagService tagService;

    @Override
    public Optional<Content> getItem(long id) {
        return repository.findById(id);
    }

    @Override
    public Page<Content> getPage(Pageable page, String filter) {
        return repository.findAll(
                (root, query, builder) -> builder.and(
                        root.get(Content_.TYPE).in(ContentType.CT_ARTICLE),
                        StringUtils.isEmpty(filter) ? builder.and() : builder.like(root.get(Content_.TITLE), filter + "%")
                ),
                page
        );
    }

    @Override
    public long createItem(Content item) {
        item.setId(null);
        item.setType(ContentType.CT_ARTICLE);
        item.setStatus(ContentStatus.CS_DRAFT);

        item.setTags(tagService.resolve(
                item.getTags().stream()
                        .map(Tag::getName)
                        .collect(Collectors.toSet())
                )
        );
        item.setFiles(null);

        return repository.save(item).getId();
    }

    @Override
    public void updateItem(long id, Content item) {
        item.setId(id);
        item.setType(ContentType.CT_ARTICLE);

        item.setTags(tagService.resolve(
                item.getTags().stream()
                        .map(Tag::getName)
                        .collect(Collectors.toSet())
                )
        );
        item.setFiles(null);

        repository.save(item);
    }

    @Override
    public void deleteItem(long id) {
        repository.deleteById(id);
    }
}
