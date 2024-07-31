package crent.neo.controller;

import crent.neo.model.Product;
import crent.neo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Page<Product>> getProducts(Pageable pageable) {
        Page<Product> products = productService.getProducts(pageable);
        return ResponseEntity.ok(products);
    }
}
