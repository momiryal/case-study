package com.cartService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.cartService.domain.cart;

@Repository
//@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<cart,Long>{

	cart findByName(String name);
	

}
