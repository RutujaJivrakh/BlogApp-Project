package com.Blog.Controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Blog.Payloads.ApiResponse;
import com.Blog.Payloads.UserDto;
import com.Blog.Services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

//POST-create user
//PUT-Update user
//DELETE-delete user
//GET-user get
	
	@Autowired
	private UserService userService;
	
//POST-create user	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto)
	{
		UserDto createUserDto = this.userService.createUser(userDto);
	    return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}

	
//PUT-Update user	
    @PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uId)
	{
    	UserDto updatedUser = this.userService.updateUser(userDto, uId);
    	return ResponseEntity.ok(updatedUser);
	}


//DELETE-delete user
    @DeleteMapping("/{userId}")
//    public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer uId)
//    {
//    	this.deleteUser(uId);
//    	return new ResponseEntity(Map.of("message","User Deleted Successfully"), HttpStatus.OK);
//    }

    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uId)
    {
    	this.userService.deleteUser(uId);
    	return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
    
    }
    
    
//GET- all user get    
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUSers()
    {
    	return ResponseEntity.ok(this.userService.getAllUser());
    }
    
//GET- one user get    
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getSingleUSer(@PathVariable Integer userId)
    {
    	return ResponseEntity.ok(this.userService.getUserById(userId));
    }
    
    
    
    
    
}
