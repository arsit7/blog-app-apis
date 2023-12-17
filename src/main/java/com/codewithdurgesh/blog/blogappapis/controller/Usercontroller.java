package com.codewithdurgesh.blog.blogappapis.controller;

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

import com.codewithdurgesh.blog.blogappapis.payloads.ApiResopnce;
import com.codewithdurgesh.blog.blogappapis.payloads.UserDto;
import com.codewithdurgesh.blog.blogappapis.services.UserServices;

@RestController
@RequestMapping("/api/users")
public class Usercontroller {

	@Autowired
	private UserServices userServices;

	// post- create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {

		UserDto createUser = this.userServices.createUser(userDto);

		return new ResponseEntity<>(createUser, HttpStatus.CREATED);
	}

	// put update - user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") Integer uId) {

		UserDto updateUser = this.userServices.UpdateUser(userDto, uId);

		return ResponseEntity.ok(updateUser);
	}

	// delete - user - single
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResopnce> deleteUser(@PathVariable("userId") Integer uid) {

		this.userServices.deleteUser(uid);

		return new ResponseEntity<ApiResopnce>(new ApiResopnce("user deleted  sucessfully..", true), HttpStatus.OK);

	}

	// Get - user -all
	@GetMapping("/all")
	public ResponseEntity<List<UserDto>> getallUser() {

		return ResponseEntity.ok(this.userServices.getallUsers());
	}

	// get - user - single

	public ResponseEntity<UserDto> getsingleUser(@PathVariable Integer userId) {

		return ResponseEntity.ok(this.userServices.getUserById(userId));
	}

}
