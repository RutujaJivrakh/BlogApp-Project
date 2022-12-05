package com.Blog.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Blog.Entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
