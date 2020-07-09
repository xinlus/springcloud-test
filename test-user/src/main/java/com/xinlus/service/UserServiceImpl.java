package com.xinlus.service;

import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.xinlus.interfaces.UserClient;
@Service
public class UserServiceImpl implements UserClient {

	@Override
	public String getUser(Long id) {
		// TODO Auto-generated method stub
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("name", "张三");
		jsonObject.addProperty("age", 16);
		return jsonObject.toString();
	}

}
