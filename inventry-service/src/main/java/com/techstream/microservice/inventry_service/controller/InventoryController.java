package com.techstream.microservice.inventry_service.controller;

import com.techstream.microservice.inventry_service.dto.InventoryRequest;
import com.techstream.microservice.inventry_service.dto.InventoryResponse;
import com.techstream.microservice.inventry_service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping(value="/inventory",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<InventoryResponse> createOrder(@RequestBody InventoryRequest request){
        return ResponseEntity.ok(inventoryService.createInventory(request));
    }

    @GetMapping(value="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<InventoryResponse>> getAllOrder(){
        return ResponseEntity.ok(inventoryService.getAllInventory());
    }

    @GetMapping(value="/quantity", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Boolean> isInStock(@RequestParam String skuCode,@RequestParam Integer quantity){
        return ResponseEntity.ok(inventoryService.isInStock(skuCode,quantity));
    }
}
