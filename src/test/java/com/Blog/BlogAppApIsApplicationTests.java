package com.Blog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Blog.Repositories.UserRepo;

@SpringBootTest
class BlogAppApIsApplicationTests {

	@Autowired
	private UserRepo userRepo;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void repoTEst()
	{
		String classname = this.userRepo.getClass().getName();
	    String packageName = this.userRepo.getClass().getPackageName();
	    
	    System.out.println(classname);
	    System.out.println(packageName);
	}
}
