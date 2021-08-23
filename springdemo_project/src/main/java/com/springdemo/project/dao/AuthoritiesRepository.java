package com.springdemo.project.dao;

import com.springdemo.project.entity.Authorities;
import com.springdemo.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository <Authorities,Integer>{


    Authorities findAllByUser(User user);
}
