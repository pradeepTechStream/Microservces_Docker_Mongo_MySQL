package com.techstream.microservice.product.service;

import com.techstream.microservice.product.dto.ProductRequest;
import com.techstream.microservice.product.dto.ProductResponse;
import com.techstream.microservice.product.model.Product;
import com.techstream.microservice.product.repository.ProductRepository;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ProductResponse createProduct(ProductRequest request){
        Product product =new Product();
        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());

        product=repository.save(product);
        ProductResponse response = new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());

        return response;
    }

    public List<ProductResponse> getAllProduct() {
        return repository.findAll().stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
                .toList();
    }
}
