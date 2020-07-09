package com.xinlus.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;

import feign.template.Template;

@Controller
public class TestController {

//	@Autowired
//	private RestTemplate restTemplate;
	@GetMapping("index")
	public String forwordUrl(String url){
		RestTemplate restTemplate  = new RestTemplate();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("phone", "b0531");
		map.put("password", "190330");
		map.put("source", 0);
        MediaType type = MediaType.parseMediaType("application/json;charset=UTF-8");

		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(type);
//	    headers.add("Host", "task.xuanshangwu.com");

	    HttpEntity<String> request = new HttpEntity<String>(JSON.toJSONString(map), headers);
		
		String response = restTemplate.postForObject("http://task.xuanshangwu.com/cold-prod-api/api/user/login",request, String.class);
		JSONObject json = JSON.parseObject(response);
		System.out.println(json.getJSONObject("data").getString("token"));
		
		return "redirect:http://task.xuanshangwu.com/#/task/mlTaskList?token="+json.getJSONObject("data").getString("token");
		
	}
}
