package xyz.crearts.blog.core.r2dbc.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import xyz.crearts.blog.core.r2dbc.entity.ContentDO;
import xyz.crearts.blog.core.r2dbc.projection.LightContentDO;

@Repository
public interface ContentRepository extends ReactiveCrudRepository<ContentDO, Long> {
    @Query(ContentSql.GET_CONTENT_PAGE)
    Flux<LightContentDO> getContentPage(Long start, Integer page);
    @Query(ContentSql.GET_CONTENT)
    Mono<ContentDO> getContent(long id);
}
