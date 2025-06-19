package com.techstream.microservice.order_service.controller;

import com.techstream.microservice.order_service.dto.OrderRequest;
import com.techstream.microservice.order_service.dto.OrderResponse;
import com.techstream.microservice.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class OrderController {

    @Autowired
    private OrderService productService;

    @PostMapping(value="/order",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request){
        return ResponseEntity.ok(productService.createOrder(request));
    }

    @GetMapping(value="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<OrderResponse>> getAllOrder(){
        return ResponseEntity.ok(productService.getAllOrder());
    }
}
