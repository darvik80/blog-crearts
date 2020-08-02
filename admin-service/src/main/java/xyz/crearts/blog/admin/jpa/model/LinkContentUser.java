package xyz.crearts.blog.admin.jpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "link_content_user")
public class LinkContentUser {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "content_id")
    private Integer contentId;

    @Column(name = "user_id")
    private Integer userId;
}
