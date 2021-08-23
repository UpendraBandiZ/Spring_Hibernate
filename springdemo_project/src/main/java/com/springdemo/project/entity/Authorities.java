package com.springdemo.project.entity;

import lombok.Data;



import javax.persistence.*;

@Data
@Entity
@Table(name = "authorities")
public class Authorities {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;



    @Column(name = "authority")
    private String authority;

    @Column(name = "username")
    private String username;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user")
    private User user;

    public Authorities()
    {

    }

   public Authorities(String authority,String username,User user)
   {
       this.authority=authority;
       this.username=username;
       this.user=user;
   }

}
