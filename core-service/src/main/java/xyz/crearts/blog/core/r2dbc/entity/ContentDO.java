package xyz.crearts.blog.core.r2dbc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;
import xyz.crearts.blog.core.r2dbc.enums.ContentStatus;
import xyz.crearts.blog.core.r2dbc.enums.ContentType;

import java.util.Date;

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
}
