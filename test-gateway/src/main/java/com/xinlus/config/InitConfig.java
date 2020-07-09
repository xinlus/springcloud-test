package com.xinlus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xinlus.filter.HostAddrKeyResolver;

@Configuration
public class InitConfig {
	@Bean
	public HostAddrKeyResolver hostAddrKeyResolver(){
		return new HostAddrKeyResolver();
	}
}
