package com.xinlus.fallback;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.xinlus.interfaces.UserClient;
import feign.hystrix.FallbackFactory;
@Component
public class MyFallBackFactory implements FallbackFactory<UserClient> {

	
	@Override
	public UserClient create(Throwable arg0) {
		// TODO Auto-generated method stub
		return new UserClient() {
			@Override
			public String getUser(Long id) {
				// TODO Auto-generated method stub
				Map<String,Object> map = new HashMap<>();
				map.put("name", "null");
				map.put("age", 0);
				return JSON.toJSONString(map);
			}
		};
	}

}
