package xyz.crearts.blog.core.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FileDTO {
    private Long id;
    private Date createdAt;
    private Date updatedAt;

    private String fileName;
    private String filePath;
    private Integer mimeType;
}
