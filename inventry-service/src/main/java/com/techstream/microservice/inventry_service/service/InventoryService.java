package com.techstream.microservice.inventry_service.service;

import com.techstream.microservice.inventry_service.dto.InventoryRequest;
import com.techstream.microservice.inventry_service.dto.InventoryResponse;
import com.techstream.microservice.inventry_service.model.Inventory;
import com.techstream.microservice.inventry_service.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository repository;

    public InventoryResponse createInventory(InventoryRequest request) {
        Inventory inventory=new Inventory();
        inventory.setCode(request.skuCode());
        inventory.setQuantity(request.quantity());

        inventory=repository.save(inventory);

        return new InventoryResponse(inventory.getId(),inventory.getCode(),inventory.getQuantity());
    }

    public List<InventoryResponse> getAllInventory() {
        return repository.findAll().stream()
                .map(inventory->new InventoryResponse(inventory.getId(),inventory.getCode(),inventory.getQuantity())).toList();
    }

    public boolean isInStock(String skuCode,Integer quantity){
        return repository.existsByCodeAndQuantity(skuCode,quantity);
    }
}
