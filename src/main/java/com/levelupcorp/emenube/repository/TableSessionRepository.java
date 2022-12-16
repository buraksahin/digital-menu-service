package com.levelupcorp.emenube.repository;

import com.levelupcorp.emenube.domain.entity.TableSession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TableSessionRepository extends JpaRepository<TableSession, Long> {
    Optional<TableSession> findById(Long id);
    Optional<TableSession> findByTableIdAndRestaurantIdAndTableCode(Long tableId, Long restaurantId, String tableCode);
}