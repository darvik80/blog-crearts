package xyz.crearts.blog.core.r2dbc.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Table("link_content_file")
@Getter
@Setter
public class LinkContentFileDO {
    @Id
    private Long id;

    private Long contentId;
    private Long FileId;
}
