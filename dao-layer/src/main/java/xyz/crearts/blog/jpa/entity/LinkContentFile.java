package xyz.crearts.blog.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "link_content_file")
public class LinkContentFile {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "content_id")
    private Long contentId;

    @Column(name = "file_id")
    private Long fileId;
}
