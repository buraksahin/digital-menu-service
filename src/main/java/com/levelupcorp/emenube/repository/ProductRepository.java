package com.levelupcorp.emenube.repository;

import com.levelupcorp.emenube.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
    List<Product> findByRestaurantId(Long restaurantId);
    List<Product> findByRestaurantIdAndCategoryId(Long restaurantId, Long categoryId);
}