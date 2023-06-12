package com.burgeranteux.service;

import com.burgeranteux.model.Product;
import com.burgeranteux.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getProductByCategory(String category) {
        return productRepository.getProductByCategory(category);
    }

    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getProduct_id()).orElse(null);
        if (existingProduct != null) {
            existingProduct.setCategory(product.getCategory());
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setImage(product.getImage());
        }
        assert existingProduct != null;
        return productRepository.save(existingProduct);
    }

    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }
}
