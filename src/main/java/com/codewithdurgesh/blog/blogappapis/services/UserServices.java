package com.codewithdurgesh.blog.blogappapis.services;

import java.util.List;


import com.codewithdurgesh.blog.blogappapis.payloads.UserDto;

public interface UserServices {

	UserDto createUser(UserDto user);

	UserDto UpdateUser(UserDto user, Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> getallUsers();

	void deleteUser(Integer userId);

}
