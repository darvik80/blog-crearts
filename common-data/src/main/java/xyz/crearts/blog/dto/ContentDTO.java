package xyz.crearts.blog.dto;

import lombok.Getter;
import lombok.Setter;
import xyz.crearts.blog.enums.ContentStatus;
import xyz.crearts.blog.enums.ContentType;

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
}
