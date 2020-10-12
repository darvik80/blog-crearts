package xyz.crearts.blog.jpa.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.crearts.blog.jpa.entity.MimeType;

@Repository
public interface MimeTypeRepository extends CrudRepository<MimeType, Long>, JpaSpecificationExecutor<MimeType> {

}
