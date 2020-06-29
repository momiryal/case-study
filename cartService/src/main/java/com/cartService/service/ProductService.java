package com.cartService.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cartService.domain.cart;
import com.cartService.dto.ProductDTO;
import com.cartService.dto.ProductMapper;
import com.cartService.repository.ProductRepository;
//import com.ibm.productservice.domain.Product;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public ProductDTO getProductById(Long id) {
		Optional<cart> product= productRepository.findById(id);
		ProductDTO productDTO=null;
		if(product.isPresent()) {
			
			ProductMapper mapper=new ProductMapper();
			System.out.println("INISDE getProductById");
			 productDTO=mapper.convertProductToProductDTO(product.get());
		}
		
		return productDTO;
	}

	public ProductDTO getProductByName(String name) {
		cart product=productRepository.findByName(name);
		ProductMapper mapper=new ProductMapper();
		return mapper.convertProductToProductDTO(product);
		
	}
	
public ProductDTO createProduct(ProductDTO dto) {
		
		ProductMapper mapper=new ProductMapper();
		cart product= mapper.convertProductDTOToProduct(dto);
		
		cart product1= productRepository.save(product);
		       return mapper.convertProductToProductDTO(product1);
		
	}
		
	}


