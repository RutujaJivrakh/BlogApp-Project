package com.Blog.Services;

import com.Blog.Payloads.CommentDto;

public interface CommentService {

	public CommentDto createComment(CommentDto commentDto,Integer postId);
	
	public void deleteComment(Integer commentId); 
}
