package com.productList.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productList.domain.Product;
import com.productList.dto.ProductDTO;
import com.productList.dto.ProductMapper;
import com.productList.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public ProductDTO getProductById(Long id) {
		Optional<Product> product= productRepository.findById(id);
		ProductDTO productDTO=null;
		if(product.isPresent()) {
			
			ProductMapper mapper=new ProductMapper();
			System.out.println("INISDE getProductById");
			 productDTO=mapper.convertProductToProductDTO(product.get());
		}
		
		return productDTO;
	}

	public ProductDTO getProductByName(String name) {
		System.out.println("*****INSIDE getProductByName*****");
		Product product=productRepository.findByName(name);
		ProductMapper mapper=new ProductMapper();
		return mapper.convertProductToProductDTO(product);
		
	}

}
