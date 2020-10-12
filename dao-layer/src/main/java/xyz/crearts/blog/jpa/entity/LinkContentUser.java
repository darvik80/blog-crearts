package xyz.crearts.blog.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "link_content_user")
public class LinkContentUser {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "content_id")
    private Long contentId;

    @Column(name = "user_id")
    private Long userId;
}
