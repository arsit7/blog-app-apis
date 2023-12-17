package com.codewithdurgesh.blog.blogappapis.repositorires;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithdurgesh.blog.blogappapis.entites.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
