package com.Blog.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blog.Entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
