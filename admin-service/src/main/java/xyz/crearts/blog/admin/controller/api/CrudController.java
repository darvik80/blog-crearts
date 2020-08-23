package xyz.crearts.blog.admin.controller.api;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import xyz.crearts.blog.admin.mapper.CrudMapper;
import xyz.crearts.blog.admin.service.CrudService;

import java.util.Optional;

@RequiredArgsConstructor
public class CrudController<T, U> {
    @Getter(AccessLevel.PROTECTED)
    private final CrudService<T, String> service;
    @Getter(AccessLevel.PROTECTED)
    private final CrudMapper<T, U> contentMapper;

    @GetMapping(value = "page", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<U> getPage(Pageable pageable, String filter) {
        return contentMapper.do2dto(service.getPage(pageable, filter));
    }

    @GetMapping(value = {"/", ""}, produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<U> getItem(@RequestParam Long id) {
        return service.getItem(id).map(contentMapper::do2dto);
    }

    @PostMapping(value = {"/", ""}, produces = MediaType.APPLICATION_JSON_VALUE)
    public long createItem(@RequestBody U content) {
        return service.createItem(contentMapper.dto2do(content));
    }

    @PutMapping(value = {"/", ""}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateItem(@RequestParam Long id, @RequestBody U content) {
        service.updateItem(id, contentMapper.dto2do(content));
    }

    @DeleteMapping(value = {"/", ""}, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteItem(@RequestParam Long id) {
        service.deleteItem(id);
    }
}
