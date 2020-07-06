package xyz.crearts.blog.core.dto;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import xyz.crearts.blog.core.r2dbc.enums.ContentStatus;
import xyz.crearts.blog.core.r2dbc.enums.ContentType;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ContentDTO {
    private Long id;
    private Date createdAt;
    private Date updatedAt;

    private ContentType type;
    private String title;
    private String content;
    private ContentStatus status;

    private List<TagDTO> tags;
    private List<FileDTO> files;

    public void setTags(String tags) {
        if (StringUtils.isNotEmpty(tags)) {
            this.tags = JSON.parseArray(tags, TagDTO.class);
        }
    }
}
