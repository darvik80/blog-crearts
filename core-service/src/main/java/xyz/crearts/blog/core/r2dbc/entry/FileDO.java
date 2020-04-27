package xyz.crearts.blog.core.r2dbc.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("file")
public class FileDO {
    @Id
    private Long id;
    private Date createdAt;
    private Date updatedAt;

    private String fileName;
    private String filePath;
    private Integer mimeType;
}
