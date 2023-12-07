package com.product.productproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.productproject.model.Product;
import com.product.productproject.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public ResponseEntity<Product> saveProduct(Product product) {
		return new ResponseEntity<>(productRepository.save(product), HttpStatus.CREATED);
	}
	
	public ResponseEntity<List<Product>> saveAllProduct(List<Product> products) {
		return new ResponseEntity<>(productRepository.saveAll(products), HttpStatus.CREATED);
	}
	
	public ResponseEntity<Optional<Product>> getProductById(int id) {
		return new ResponseEntity<>(productRepository.findById(id), HttpStatus.OK);
	}
	
	public ResponseEntity<Optional<Product>> getProductByname(String name) {
		return new ResponseEntity<>(productRepository.findByName(name), HttpStatus.OK );
	}
	
	public ResponseEntity<String> deleteProduct(int id) {
		productRepository.deleteById(id);
		return new ResponseEntity<>("Product removed with id = "+id, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<Product> updateProduct(int id, Product product) {
		Optional<Product> existingProduct = productRepository.findById(id);
		
		Product exitProduct = existingProduct.get();
		exitProduct.setName(product.getName());
		exitProduct.setPrice(product.getPrice());
		exitProduct.setQuantity(product.getQuantity());
		
		return new  ResponseEntity<>(productRepository.save(exitProduct), HttpStatus.OK);
	}

	public ResponseEntity<List<Product>> getAllProducts() {
		
		return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
	}
	
	
}
