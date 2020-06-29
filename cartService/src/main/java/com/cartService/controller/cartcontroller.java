package com.cartService.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cartService.domain.cart;
import com.cartService.dto.ProductDTO;
import com.cartService.service.ProductService;
import com.cartService.service.ProductServiceProxy;


@RestController
public class cartcontroller {
	@Autowired
	ProductServiceProxy proxyservice;
	
	String item;
	
	@RequestMapping("cart/start")
	public String getStartupMessage() {
		
		return "Welcome to ****CART*** page";
	}
	
	@Autowired
	ProductService productservice;
	
	@GetMapping("cartitems/{id}")
	public ResponseEntity<ProductDTO> searchByProductID(@PathVariable(value="id") Long id) {
		
					
		return ResponseEntity.ok().body(productservice.getProductById(id));
		
	}
	
/*	@GetMapping("cart/productItem/{name}")
	public ProductDTO productItem(@PathVariable(value="name") String name) {
		System.out.println("*****INSIDE cartcontroller SEARCH item *****");
		
		 ProductDTO dtofromProductService = proxyservice.searchByProductName(name); //search product from proxy service.
				//productservice.createProduct(dtofromProductService); //add product to cart DB
				return dtofromProductService;
	}*/
	@GetMapping("/cart/add/{name}")
	public ResponseEntity<ProductDTO> createProduct(@PathVariable(value="name") String name) {
		
		ProductDTO search = searchItem(name);
		//ProductDTO dtofromProductService = proxyservice.searchByProductName(item);
		ProductDTO dto=productservice.createProduct(search);
		return ResponseEntity.ok().body(search);
	}
	
	public ProductDTO searchItem(String item) {
		
		ProductDTO dtofromProductService = proxyservice.searchByProductName(item);
		return dtofromProductService;
	}
	
}
