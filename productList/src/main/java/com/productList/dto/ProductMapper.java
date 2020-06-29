package com.productList.dto;

import com.productList.domain.Product;

public class ProductMapper {
	
	
	public ProductDTO convertProductToProductDTO(Product product) {
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setPrice(product.getPrice());
		productDTO.setQuantity(product.getQuantity());
		
		return productDTO;
		
	}

}
