package com.productList.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productList.domain.Product;
import com.productList.dto.ProductDTO;
import com.productList.service.ProductService;


@RestController
public class productcontroller {

	@RequestMapping("/message")
	public String getMessage() {
		
		return "Product details page";
	}
	@RequestMapping("/start")
	public String getStartupMessage() {
		
		return "Welcome to product service page";
	}
	
	@Autowired
	ProductService productservice;
	
	@GetMapping("product/{id}")
	public ResponseEntity<ProductDTO> searchByProductID(@PathVariable(value="id") Long id) {
		
					
		return ResponseEntity.ok().body(productservice.getProductById(id));
		
	}
	
	@RequestMapping("item/{name}")
	public ResponseEntity<ProductDTO> searchByProductName(@PathVariable(value="name") String name) {
		
		System.out.println("****INSIDE searchByProductName*****");
		return ResponseEntity.ok().body(productservice.getProductByName(name));
		
	}
}
