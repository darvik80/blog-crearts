package xyz.crearts.blog.admin.jpa.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.crearts.blog.admin.jpa.model.Content;

@Repository
public interface ContentRepository extends CrudRepository<Content, Long>, JpaSpecificationExecutor<Content> {

}
