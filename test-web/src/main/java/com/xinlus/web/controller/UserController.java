package com.xinlus.web.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xinlus.interfaces.UserClient;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserClient userClient;
	@GetMapping("/{id}")
	public String getUser(@PathVariable Long id){
		return userClient.getUser(id);
	}
}
