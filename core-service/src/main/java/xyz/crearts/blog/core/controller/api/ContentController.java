package xyz.crearts.blog.core.controller.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.crearts.blog.core.service.ContentService;
import xyz.crearts.blog.dto.ContentDTO;

import java.util.Optional;

@RestController
@RequestMapping("/api/content")
@RequiredArgsConstructor
public class ContentController {
    private final ContentService contentService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<ContentDTO> getContent(@RequestParam Long id) {
        return contentService.getContent(id);
    }

    @GetMapping(value = "page", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<ContentDTO> getContentPage(@RequestParam Integer page, @RequestParam Integer size) {
        return contentService.getContentPage(PageRequest.of(page, size));
    }
}
