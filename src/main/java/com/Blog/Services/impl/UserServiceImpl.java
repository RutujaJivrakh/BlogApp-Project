package com.Blog.Services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Blog.Entities.User;
import com.Blog.Exceptions.ResourceNotFoundException;
import com.Blog.Payloads.UserDto;
import com.Blog.Repositories.UserRepo;
import com.Blog.Services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
       User user=this.dtoToUser(userDto);
       User savedUser=this.userRepo.save(user);
	   return this.UserToDto(savedUser);
	}

	
	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
        User user =this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updatedUser = this.userRepo.save(user);
        UserDto userDto1 = this.UserToDto(updatedUser);
		return userDto1;
	}

	
	@Override
	public UserDto getUserById(Integer userId) {
        User user =this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
      
		return this.UserToDto(user);
	}

	
	@Override
	public List<UserDto> getAllUser() {
        List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(User->this.UserToDto(User)).collect(Collectors.toList());
        return userDtos;
	}

	
	@Override
	public void deleteUser(Integer userId) {
        User user =this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
        this.userRepo.delete(user);
	}

	
	
//	public User dtoToUser(UserDto userDto)
//	{
//		User user=new User();
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
//		return user;
//		}
	
//Using Model Mapper	
	public User dtoToUser(UserDto userDto)
	{
		User user=this.modelMapper.map(userDto, User.class);
	    return user;
	}
	
	
//	public UserDto UserToDto(User user)
//	{
//		UserDto userDto=new UserDto();
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
//		return userDto;
//	}
	
	public UserDto UserToDto(User user)
	{
		UserDto userDto=this.modelMapper.map(user, UserDto.class);
		return userDto;
	}
	
}
