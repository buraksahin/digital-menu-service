package com.levelupcorp.emenube.service;

import com.levelupcorp.emenube.domain.entity.Product;
import com.levelupcorp.emenube.domain.request.ProductRequest;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getById(Long productId);
    List<Product> getByRestaurantId(Long restaurantId);
    List<Product> getByRestaurantIdAndCategoryId(Long restaurantId, Long categoryId);
    Product createProduct(ProductRequest productRequest);
    Product updateProduct(ProductRequest productRequest, Long productId);
    Boolean deleteProduct(Long productId);
}
