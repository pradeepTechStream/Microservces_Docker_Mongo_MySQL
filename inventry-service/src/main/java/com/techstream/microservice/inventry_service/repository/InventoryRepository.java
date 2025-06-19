package com.techstream.microservice.inventry_service.repository;

import com.techstream.microservice.inventry_service.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    boolean existsByCodeAndQuantity(String skuCode, Integer quantity);
}
