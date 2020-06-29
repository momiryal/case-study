package com.oauth.jwt.ds.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.logging.Logger;

@RestController
@RequestMapping("/me")
public class UserController {

	private static final Logger LOG = Logger.getLogger(UserController.class.getName());
	
	@Autowired
	ProductServiceProxy proxyservice;
	
	@Autowired
	cartProxyService cartProxy;
    
	@GetMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public String productHome() {
    	return "I am in home page !!";
    }
    		/*  public ResponseEntity<Principal> get(final Principal principal) {
        return ResponseEntity.ok(principal);
    	}*/
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping("/productStart")
    public String productstart() {
    	
		LOG.info("**In productstart() of UserController before calling proxy**");
    	
		return proxyservice.getStartupMessage();
    }
    
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping("/productHome")
	public String productdetail() {
		
		return proxyservice.getMessage();
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping("/productItem/{name}")
	public ProductDTO productItem(@PathVariable(value="name") String name) {
		
		return proxyservice.searchByProductName(name);
	}
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping("/cart/add/{name}")
	public ProductDTO cartitem(@PathVariable(value="name") String name) {
		
		return cartProxy.createProduct(name);
	}

}
