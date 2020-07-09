package com.xinlus.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
@Order(Integer.MIN_VALUE)
public class GatewayFile implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// TODO Auto-generated method stub
		ServerHttpRequest request = exchange.getRequest();
		String mothed = request.getMethodValue();
		String path = request.getURI().getPath();
		String beforePath = request.getPath().pathWithinApplication().value();
		System.out.println(String.format("【请求的URL】:{0}:{1}",mothed,path));
		return chain.filter(exchange).then(Mono.fromRunnable(() ->{
			ServerHttpResponse response = exchange.getResponse();
			System.out.println("【响应码】:"+response.getStatusCode());
		}));
	}

}
