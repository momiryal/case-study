package com.cartService.dto;

import com.cartService.domain.cart;
import com.cartService.dto.ProductDTO;

public class ProductMapper {
	
	
	public ProductDTO convertProductToProductDTO(cart product) {
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setPrice(product.getPrice());
		productDTO.setQuantity(product.getQuantity());
		
		return productDTO;
		
	}
	public cart convertProductDTOToProduct(ProductDTO dto) {
		
		cart product=new cart();
		product.setId(dto.getId());
		product.setPrice(dto.getPrice());
		product.setName(dto.getName());
		product.setQuantity(dto.getQuantity());
		
		return product;
	}

}
