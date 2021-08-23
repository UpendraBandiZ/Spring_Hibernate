package com.springdemo.project.entity;



import com.sun.istack.internal.NotNull;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;


    @Column(name = "username")
    private String username;



    @Column(name="password")
    private String password;

    @Column(name = "enabled")
    private  int enabled;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private Authorities authority;

    public User()
    {

    }
    public User(String username, String password, int enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

}
