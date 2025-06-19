package com.techstream.microservice.order_service.service;

import com.techstream.microservice.order_service.client.InventoryClient;
import com.techstream.microservice.order_service.dto.OrderRequest;
import com.techstream.microservice.order_service.dto.OrderResponse;
import com.techstream.microservice.order_service.model.Order;
import com.techstream.microservice.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private InventoryClient inventoryClient;


    @Autowired
    private OrderRepository repository;

    public OrderResponse createOrder(OrderRequest request) {
        boolean isProductInStock = inventoryClient.isInStock(request.code(),request.quantity());
        Order order=new Order();
        if(isProductInStock){
            order.setNumber(request.orderNumber());
            order.setCode(request.code());
            order.setQuantity(request.quantity());
            order.setPrice(request.price());
            order=repository.save(order);
            return new OrderResponse(order.getId(), order.getNumber(),order.getCode(),order.getPrice(),order.getQuantity());
        }else{
            throw new RuntimeException("Product with SkuCode"+order.getCode()+"Is not in stock");
        }
    }

    public List<OrderResponse> getAllOrder() {
        return repository.findAll().stream()
                .map(order->new OrderResponse(order.getId(), order.getNumber(),order.getCode(),order.getPrice(),order.getQuantity())).toList();
    }
}
