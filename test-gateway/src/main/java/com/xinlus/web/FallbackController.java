package com.xinlus.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonObject;

@RestController
public class FallbackController {
	@RequestMapping("/fallback")
	public String fallback(){
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("status", "503");
		jsonObject.addProperty("message", "服务器繁忙");
		jsonObject.addProperty("timeStamp", System.currentTimeMillis());
		return jsonObject.toString();
	}
}
