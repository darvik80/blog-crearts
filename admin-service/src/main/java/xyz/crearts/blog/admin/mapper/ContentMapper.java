package xyz.crearts.blog.admin.mapper;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import xyz.crearts.blog.admin.jpa.model.Content;
import xyz.crearts.blog.dto.ContentDTO;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContentMapper {
    default Page<ContentDTO> page(Page<Content> data) {
        return new PageImpl<>(
                do2dto(data.getContent()),
                data.getPageable(),
                data.getTotalElements()
        );
    }

    ContentDTO do2dto(Content data);

    List<ContentDTO> do2dto(List<Content> data);
}
