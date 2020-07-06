package xyz.crearts.blog.core.dto;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Getter
@Setter
public class LightContentDTO {
    private Long id;
    private String title;
    private String content;

    private List<TagDTO> tags;

    public void setTags(String tags) {
        if (StringUtils.isNotEmpty(tags)) {
            this.tags = JSON.parseArray(tags, TagDTO.class);
        }
    }
}
