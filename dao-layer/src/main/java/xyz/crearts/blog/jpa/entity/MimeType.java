package xyz.crearts.blog.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "mime_type")
public class MimeType {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;
}
