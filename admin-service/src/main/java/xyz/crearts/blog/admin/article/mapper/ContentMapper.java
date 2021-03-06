package xyz.crearts.blog.admin.article.mapper;

import org.mapstruct.Mapper;
import xyz.crearts.blog.admin.mapper.CrudMapper;
import xyz.crearts.blog.dto.ContentDTO;
import xyz.crearts.blog.jpa.entity.Content;

@Mapper(componentModel = "spring")
public interface ContentMapper extends CrudMapper<Content, ContentDTO> {
    ContentDTO do2dto(Content item);
    Content dto2do(ContentDTO item);
}
