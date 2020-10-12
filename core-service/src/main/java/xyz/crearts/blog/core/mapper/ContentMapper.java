package xyz.crearts.blog.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import xyz.crearts.blog.dto.ContentDTO;
import xyz.crearts.blog.dto.LightContentDTO;
import xyz.crearts.blog.jpa.entity.Content;
import xyz.crearts.blog.jpa.projection.LightContentDO;

@Mapper
public interface ContentMapper {
    ContentMapper INSTANCE = Mappers.getMapper( ContentMapper.class );
    ContentDTO do2dto(Content data);

    @Mapping(source = "tags", target = "tags")
    LightContentDTO do2dto(LightContentDO data);
}
