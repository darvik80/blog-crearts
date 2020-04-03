package xyz.crearts.blog.core.r2dbc.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MimeTypeDO {
    @Id
    private Long id;
    private String name;
}
