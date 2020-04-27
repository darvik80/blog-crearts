package xyz.crearts.blog.core.r2dbc.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("mime_type")
public class MimeTypeDO {
    @Id
    private Long id;
    private String name;
}
