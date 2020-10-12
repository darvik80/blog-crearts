package xyz.crearts.blog.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "account_role")
@Data
public class AccountRole {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;
}
