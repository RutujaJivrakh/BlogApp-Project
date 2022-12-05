package com.Blog.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blog.Entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
