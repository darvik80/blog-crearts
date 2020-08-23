package xyz.crearts.blog.admin.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CrudService<T, F> {
    Optional<T> getItem(long id);
    Page<T> getPage(Pageable page, F filter);

    long createItem(T item);

    void updateItem(long id, T item);
    void deleteItem(long id);
}
