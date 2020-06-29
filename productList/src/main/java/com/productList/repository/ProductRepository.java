package com.productList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productList.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{

	Product findByName(String name);

}
