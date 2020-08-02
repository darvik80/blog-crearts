package xyz.crearts.blog.core.r2dbc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("tag")
public class TagDO {
    @Id
    private Long id;
    private String name;
    private long color;
}
