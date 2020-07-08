package xyz.crearts.blog.core.r2dbc.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import xyz.crearts.blog.core.r2dbc.entity.MimeTypeDO;

@Repository
public interface MimeTypeRepository extends ReactiveCrudRepository<MimeTypeDO, Long> {
}
