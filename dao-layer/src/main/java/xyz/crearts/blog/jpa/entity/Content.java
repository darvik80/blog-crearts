package xyz.crearts.blog.jpa.entity;

import lombok.Data;
import xyz.crearts.blog.jpa.enums.ContentStatus;
import xyz.crearts.blog.jpa.enums.ContentType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "content")
@Data
public class Content {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "created_at", insertable = false, updatable = false)
    private Date createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    private Date updatedAt;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ContentType type;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ContentStatus status;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "link_content_tag",
            joinColumns = { @JoinColumn(name = "content_id") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id") }
    )
    private List<Tag> tags;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "link_content_file",
            joinColumns = { @JoinColumn(name = "content_id") },
            inverseJoinColumns = { @JoinColumn(name = "file_id") }
    )
    private List<File> files;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "link_content_user",
            joinColumns = { @JoinColumn(name = "content_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    private List<User> users;
}
