package xyz.crearts.blog.admin.jpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "mime_type")
public class MimeType {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;
}
