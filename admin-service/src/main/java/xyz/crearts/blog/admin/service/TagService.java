package xyz.crearts.blog.admin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import xyz.crearts.blog.jpa.entity.Tag;
import xyz.crearts.blog.jpa.enums.ContentType;
import xyz.crearts.blog.jpa.repository.TagRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagService implements CrudService<Tag, String> {
    public static final int DEFAULT_COLOR = 0x00FF0000;

    private final TagRepository repository;

    @Override
    public Optional<Tag> getItem(long id) {
        return repository.findById(id);
    }

    @Override
    public Page<Tag> getPage(Pageable page, String filter) {
        return repository.findAll(
                (root, query, builder) -> builder.and(
                        root.get("type").in(ContentType.CT_ARTICLE),
                        StringUtils.isEmpty(filter) ? builder.and() : builder.like(root.get("title"), filter + "%")
                ),
                page
        );

    }

    @Override
    public long createItem(Tag item) {
        item.setId(null);
        return repository.save(item).getId();
    }

    @Override
    public void updateItem(long id, Tag item) {
        item.setId(id);
        repository.save(item);
    }

    @Override
    public void deleteItem(long id) {
        repository.deleteById(id);
    }

    public List<Tag> resolve(Set<String> tags) {
        var existsTags = repository.findAllByNameIn(tags);
        if (existsTags.size() < tags.size()) {
            var result = new ArrayList<Tag>();
            var existed = existsTags.stream()
                    .map(Tag::getName)
                    .filter(tags::contains)
                    .collect(Collectors.toSet());

            tags.forEach(tag -> {
                if (!existed.contains(tag)) {
                    //result.add(repository.save(Tag.builder().name(tag).color(DEFAULT_COLOR).build()));
                }
            });
            result.addAll(existsTags);

            return result;
        }

        return existsTags;
    }
}
