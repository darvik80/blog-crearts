package xyz.crearts.blog.jpa.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xyz.crearts.blog.jpa.entity.Tag;

import java.util.Collection;
import java.util.List;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long>, JpaSpecificationExecutor<Tag> {
    List<Tag> findAllByNameIn(Collection<String> tags);
}
