package com.oauth.jwt.ds.web;

import java.util.logging.Logger;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="productservice")
public interface ProductServiceProxy {
	
	
	@RequestMapping("/message")
	public String getMessage();
	
	@RequestMapping("/start")
	public String getStartupMessage();
	
	@RequestMapping("item/{name}")
	public ProductDTO searchByProductName(@PathVariable(value="name") String name);
}
