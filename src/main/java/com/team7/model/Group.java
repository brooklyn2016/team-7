package com.team7.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Created by sd95 on 10/28/16.
 */
@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
