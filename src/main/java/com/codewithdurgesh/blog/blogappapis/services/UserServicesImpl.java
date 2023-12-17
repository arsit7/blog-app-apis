package com.codewithdurgesh.blog.blogappapis.services;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithdurgesh.blog.blogappapis.entites.User;
import com.codewithdurgesh.blog.blogappapis.payloads.UserDto;
import com.codewithdurgesh.blog.blogappapis.repositorires.UserRepo;
import com.codewithdurgesh.blog.blogappapis.exceptions.*;

@Service
public class UserServicesImpl implements UserServices {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDto createUser(UserDto userDto) {

		User user = this.dtotoUser(userDto);
		User save = this.userRepo.save(user);
         
		return this.userTODto(user);
	}

	@Override
	public UserDto UpdateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFOundException("user", "id", userId));

		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(user.getPassword());
		user.setAbout(userDto.getAbout());

		User updateuser = this.userRepo.save(user);
		UserDto userDto1 = this.userTODto(updateuser);

		return userDto;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		
		 User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFOundException("user", "id", userId));
		return this.userTODto(user);
	}

	@Override
	public List<UserDto> getallUsers() {
		List<User> list = this.userRepo.findAll();
		 
		List<UserDto> collect = list.stream().map(user->this.userTODto(user)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public void deleteUser(Integer userId) {
	 User	user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFOundException("user", "id", userId));

	 this.userRepo.delete(user);
	  
	  
	}
	

	private User dtotoUser(UserDto userDto) {

		User user = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		return user;
	}

	public UserDto userTODto(User user) {

		UserDto userdto = new UserDto();
		userdto.setId(user.getId());
		userdto.setName(user.getName());
		userdto.setEmail(user.getEmail());
		userdto.setPassword(user.getPassword());
		userdto.setAbout(user.getAbout());

		return userdto;

	}

}
