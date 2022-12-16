package com.levelupcorp.emenube.repository;

import com.levelupcorp.emenube.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findById(Long id);
    List<Order> findByTableId(Long tableId);
    List<Order> findByRestaurantId(Long restaurantId);
    List<Order> findByTableIdAndCustomerName(Long tableId, String customerName);
    List<Order> findByTableIdAndRestaurantId(Long tableId, Long restaurantId);
    List<Order> findByTableIdAndCustomerNameAndRestaurantId(Long tableId, String customerName, Long restaurantId);
}