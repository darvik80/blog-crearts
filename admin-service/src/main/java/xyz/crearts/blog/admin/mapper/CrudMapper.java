package xyz.crearts.blog.admin.mapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.stream.Collectors;

public interface CrudMapper<T, U> {
    T dto2do(U item);
    U do2dto(T item);

    default Page<U> do2dto(Page<T> page) {
        return new PageImpl<>(
                page.getContent().stream().map(this::do2dto).collect(Collectors.toList()),
                page.getPageable(),
                page.getTotalElements()
        );
    }


    default Page<T> dto2do(Page<U> page) {
        return new PageImpl<>(
                page.getContent().stream().map(this::dto2do).collect(Collectors.toList()),
                page.getPageable(),
                page.getTotalElements()
        );
    }
}
