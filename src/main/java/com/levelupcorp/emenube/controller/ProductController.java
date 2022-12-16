package com.levelupcorp.emenube.controller;

import com.levelupcorp.emenube.domain.entity.Product;
import com.levelupcorp.emenube.domain.request.ProductRequest;
import com.levelupcorp.emenube.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/get-by-product-id/{product-id}")
    public ResponseEntity<Product> getProductByProductId(@PathVariable("product-id") Long productId) {
        return ResponseEntity.ok(productService.getById(productId));
    }

    @GetMapping("/get-by-restaurant-id/{restaurant-id}")
    public ResponseEntity<List<Product>> getProductsByResturantId(@PathVariable("restaurant-id") Long restaurantId) {
        return ResponseEntity.ok(productService.getByRestaurantId(restaurantId));
    }

    @GetMapping("/get-by-restaurant-id-and-category-id/{restaurant-id}/{category-id}")
    public ResponseEntity<List<Product>> getProductsByRestaurantIdAndCategoryId(@PathVariable("restaurant-id") Long restaurantId, @PathVariable("category-id") Long categoryId) {
        return ResponseEntity.ok(productService.getByRestaurantIdAndCategoryId(restaurantId, categoryId));
    }

    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        Product createdProduct = productService.createProduct(productRequest);
        return ResponseEntity.ok(createdProduct);
    }

    @PatchMapping("/update/{product-id}")
    public ResponseEntity<Product> updateProduct(@RequestBody @Valid ProductRequest productRequest, @PathVariable("product-id") Long productId) {
        Product updatedProduct = productService.updateProduct(productRequest, productId);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/delete/{product-id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("product-id") @Valid Long productId) {
        return ResponseEntity.ok(productService.deleteProduct(productId));
    }
}
