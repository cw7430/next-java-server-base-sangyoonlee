package com.next.app.api.user.controller;

import com.next.app.api.user.entity.ProductIltuo;
import com.next.app.api.user.service.IltuoProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
@Tag(name = "Product Controller", description = "상품 관리 API")
@CrossOrigin(origins = "http://localhost")
public class ProductController {
    @Autowired
    private final IltuoProductService productService;

    @GetMapping
    public List<ProductIltuo> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductIltuo getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductIltuo createProduct(@RequestBody ProductIltuo product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public ProductIltuo updateProduct(@PathVariable Long id, @RequestBody ProductIltuo product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
