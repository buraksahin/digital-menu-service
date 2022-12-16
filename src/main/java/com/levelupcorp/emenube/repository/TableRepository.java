package com.levelupcorp.emenube.repository;

import com.levelupcorp.emenube.domain.entity.Table;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TableRepository extends JpaRepository<Table, Long> {
    Optional<Table> findById(Long id);
    List<Table> findByRestaurantId(Long restaurantId);
    Optional<Table> findByIdAndRestaurantIdAndSessionCode(Long id, Long restaurantId, String sessionCode);
}