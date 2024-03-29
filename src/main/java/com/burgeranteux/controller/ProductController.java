package com.burgeranteux.controller;

import com.burgeranteux.model.Product;
import com.burgeranteux.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") int id) {
        return productService.getProduct(id);
    }

    @GetMapping("/category/{category}")
    public List<Product> getProductByCategory(@PathVariable("category") String category) {
        return productService.getProductByCategory(category);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updateProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") int id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
