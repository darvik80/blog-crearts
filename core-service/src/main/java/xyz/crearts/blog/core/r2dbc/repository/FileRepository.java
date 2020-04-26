package xyz.crearts.blog.core.r2dbc.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import xyz.crearts.blog.core.r2dbc.entry.MimeTypeDO;

public interface FileRepository extends ReactiveCrudRepository<MimeTypeDO, Long> {
}
