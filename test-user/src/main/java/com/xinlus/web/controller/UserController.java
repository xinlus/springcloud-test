package com.xinlus.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xinlus.interfaces.UserClient;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserClient userClient;
	@GetMapping("/{id}")
	public String getUser(@PathVariable("id") Long id){
		int i = 1/0;
		return userClient.getUser(id);
	}
}
