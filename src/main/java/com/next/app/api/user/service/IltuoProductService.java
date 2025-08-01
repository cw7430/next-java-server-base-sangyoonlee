package com.next.app.api.user.service;

import com.next.app.api.user.entity.ProductIltuo;
import com.next.app.api.user.repository.ProductIltuoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class IltuoProductService {
    @Autowired
    private final ProductIltuoRepository productIltuoRepository;

    public List<ProductIltuo> getAllProducts() {
       return productIltuoRepository.findAll();
    }

    public ProductIltuo getProductById(Long id) {
        return productIltuoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public ProductIltuo createProduct(ProductIltuo product) {
        return productIltuoRepository.save(product);
    }

    public ProductIltuo updateProduct(Long id, ProductIltuo updatedProduct) {
        ProductIltuo product = productIltuoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        product.setDescription(updatedProduct.getDescription());
        return productIltuoRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productIltuoRepository.deleteById(id);
    }

}
