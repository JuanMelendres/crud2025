package com.coursejjjm.simplecrud.controller;

import com.coursejjjm.simplecrud.model.product.Product;
import com.coursejjjm.simplecrud.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
public class ProductController {

    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        try{
            Product newProduct = productService.save(product);
            log.info("New product created: {}", newProduct);
            return ResponseEntity.status(201).body(newProduct);
        } catch (Exception e) {
            log.error("Error creating product: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        try{
            List<Product> products = productService.findAll();
            log.info("All products retrieved: {}", products);
            return ResponseEntity.ok().body(products);
        } catch (Exception e) {
            log.error("Error getting products: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}") // @GetMapping("/id")
    public ResponseEntity<Product> getProductByID(@PathVariable int id) { // @RequestParam("id") int id
        try{
            Product product = productService.findById(id);
            log.info("Product retrieved: {}", product);
            return ResponseEntity.ok().body(product);
        } catch (Exception e) {
            log.error("Error retrieving product: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        try{
            Product updatedProduct = productService.update(product);
            log.info("Product updated: {}", updatedProduct);
            return ResponseEntity.ok().body(updatedProduct);
        } catch (Exception e) {
            log.error("Error updating product: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable int id) {
        try{
            productService.deleteById(id);
            log.info("Product deleted: {}", id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(true);
        } catch (Exception e) {
            log.error("Error deleting product: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

   @PostMapping("/random")
    public ResponseEntity<Product> createRandomProduct() {
        try{
            Product product = productService.createRandmProduct();
            log.info("New random product created: {}", product);
            return ResponseEntity.status(HttpStatus.CREATED).body(product);
        } catch (Exception e) {
            log.error("Error creating random product: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
   }

}
