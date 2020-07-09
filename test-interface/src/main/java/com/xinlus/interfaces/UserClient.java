package com.xinlus.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.xinlus.fallback.MyFallBackFactory;

@FeignClient(value="test-user",fallbackFactory = MyFallBackFactory.class)
public interface UserClient {
	@GetMapping("user/{id}")
	public String getUser(@PathVariable("id") Long id);
}
