package xyz.crearts.blog.core.r2dbc.entity;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.util.StringUtils;
import xyz.crearts.blog.dto.TagDTO;
import xyz.crearts.blog.enums.ContentStatus;
import xyz.crearts.blog.enums.ContentType;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Table("content")
@Getter
@Setter
public class ContentDO {
    @Id
    private Long id;
    private Date createdAt;
    private Date updatedAt;

    private ContentType type;
    private String title;
    private String content;

    private ContentStatus status;

    private String tags;

    public List<TagDO> getTags() {
        if (StringUtils.isEmpty(tags)) {
            return Collections.emptyList();
        }

        return JSON.parseArray(tags, TagDO.class);
    }

}
