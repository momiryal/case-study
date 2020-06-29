package com.oauth.jwt.ds.web;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@FeignClient(name="cartservice")
public interface cartProxyService {

	@RequestMapping("/cart/add/{name}")
	public ProductDTO createProduct(@PathVariable(value="name") String name);
	
}
