package com.springdemo.project.dao;

import com.springdemo.project.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String companyName);
}
