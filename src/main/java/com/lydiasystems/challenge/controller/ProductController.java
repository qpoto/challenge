package com.lydiasystems.challenge.controller;

import com.lydiasystems.challenge.entity.DTO.ProductDTO;
import com.lydiasystems.challenge.entity.Product;
import com.lydiasystems.challenge.repository.ProductRepository;
import com.lydiasystems.challenge.service.ProductListingService;
import com.lydiasystems.challenge.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductListingService productListingService;
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<Map<ProductDTO, Long>> getAllProducts() {
        Map<ProductDTO, Long> products = productListingService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<String> saveOrUpdateProduct(@RequestBody Product product) {
        productService.saveOrUpdate(product);
        return ResponseEntity.ok("Product saved or updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@RequestBody Product product) {
        productService.delete(product);
        return ResponseEntity.ok("Product deleted successfully");
    }
}
