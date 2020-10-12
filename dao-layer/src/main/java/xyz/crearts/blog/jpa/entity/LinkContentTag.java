package xyz.crearts.blog.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "link_content_tag")
public class LinkContentTag {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "content_id")
    private Long contentId;

    @Column(name = "tag_id")
    private Long tagId;
}
