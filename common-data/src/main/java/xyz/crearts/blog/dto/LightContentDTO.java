package xyz.crearts.blog.dto;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LightContentDTO {
    private Long id;
    private String title;
    private String content;

    private List<TagDTO> tags;

    public void setTags(String tags) {
        if (tags != null & tags.length() > 0) {
            this.tags = JSON.parseArray(tags, TagDTO.class);
        }
    }
}
