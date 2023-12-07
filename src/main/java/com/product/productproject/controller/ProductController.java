package com.product.productproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.productproject.model.Product;
import com.product.productproject.service.ProductService;


@RestController
@RequestMapping("api")
public class ProductController {
	
	@Autowired
	ProductService productService;
		
// create
	@PostMapping("/products/add-one")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@PostMapping("/products/add-multi")
	public ResponseEntity<List<Product>> addProducts(@RequestBody List<Product> products) {
		return productService.saveAllProduct(products);
	}
	
// read
	@GetMapping("/products/all")
	public ResponseEntity<List<Product>> findAllProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/products/id/{id}")
	public ResponseEntity<Optional<Product>> findProductById(@PathVariable int id) {
		return productService.getProductById(id);
	}
	
	@GetMapping("/products/name/{name}")
	public ResponseEntity<Optional<Product>> findProductName(@PathVariable String name) {
		return productService.getProductByname(name);
	}
	
	
// update 
	@PutMapping("/products/update/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable int id ,@RequestBody Product product) {
		return productService.updateProduct(id, product);
	}
	
	
// delete
	@DeleteMapping("/products/delete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id) {
		return productService.deleteProduct(id);
	}
	
	

}
