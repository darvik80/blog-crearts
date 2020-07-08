package xyz.crearts.blog.core.controller.api;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import xyz.crearts.blog.core.dto.ContentDTO;
import xyz.crearts.blog.core.dto.LightContentDTO;
import xyz.crearts.blog.core.service.ContentService;

@RestController
@RequestMapping("/api/content")
@RequiredArgsConstructor
public class ContentController {
    private final ContentService contentService;

    @GetMapping("")
    public Mono<ContentDTO> getContent(@RequestParam Long id) {
        return contentService.getContent(id);
    }

    @GetMapping("page")
    public Flux<LightContentDTO> getContentPage(@RequestParam Integer page, @RequestParam Integer size) {
        return contentService.getContentPage(PageRequest.of(page, size));
    }
}
