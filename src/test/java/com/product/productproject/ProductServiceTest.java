package com.product.productproject;

import static org.mockito.Mockito.*;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.product.productproject.model.Product;
import com.product.productproject.repository.ProductRepository;
import com.product.productproject.service.ProductService;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    public void testSaveProduct() {
        // Arrange
        Product productToSave = new Product(1, "TestProduct", 10, 25.0);

        when(productRepository.save(productToSave)).thenReturn(productToSave);

        // Act
        ResponseEntity<Product> response = productService.saveProduct(productToSave);

        // Assert
        assertProductResponse(response, productToSave, HttpStatus.CREATED);
    }

    @Test
    public void testGetProductById() {
        // Arrange
        int productId = 1;
        Product product = new Product(productId, "TestProduct", 10, 25.0);

        when(productRepository.findById(productId)).thenReturn(Optional.of(product));

        // Act
        ResponseEntity<Optional<Product>> response = productService.getProductById(productId);

        // Assert
        assertOptionalResponse(response, Optional.of(product), HttpStatus.OK);
    }

    @Test
    public void testUpdateProduct() {
        // Arrange
        int productId = 1;
        Product existingProduct = new Product(productId, "ExistingProduct", 10, 25.0);
        Product updatedProduct = new Product(productId, "UpdatedProduct", 15, 30.0);

        when(productRepository.findById(productId)).thenReturn(Optional.of(existingProduct));
        when(productRepository.save(existingProduct)).thenReturn(updatedProduct);

        // Act
        ResponseEntity<Product> response = productService.updateProduct(productId, updatedProduct);

        // Assert
        assertProductResponse(response, updatedProduct, HttpStatus.OK);
    }

    @Test
    public void testDeleteProduct() {
        // Arrange
        int productId = 1;
        Product productToDelete = new Product(productId, "TestProduct", 10, 25.0);

        // No need to mock the repository as the delete method doesn't return anything

        // Act
        ResponseEntity<String> response = productService.deleteProduct(productId);

        // Assert
        assertStringResponse(response, "Product removed with id = " + productId, HttpStatus.ACCEPTED);
    }

    private <T> void assertProductResponse(ResponseEntity<T> response, T expectedBody, HttpStatus expectedStatus) {
        assertResponse(response, expectedBody, expectedStatus);
    }

    private <T> void assertOptionalResponse(ResponseEntity<T> response, T expectedBody, HttpStatus expectedStatus) {
        assertResponse(response, expectedBody, expectedStatus);
    }

    private <T> void assertStringResponse(ResponseEntity<T> response, T expectedBody, HttpStatus expectedStatus) {
        assertResponse(response, expectedBody, expectedStatus);
    }

    private <T> void assertResponse(ResponseEntity<T> response, T expectedBody, HttpStatus expectedStatus) {
        assert response.getBody() != null;
        assert response.getBody().equals(expectedBody);
        assert response.getStatusCode().equals(expectedStatus);
    }
}

