package com.techstream.microservice.order_service.dto;

import java.math.BigDecimal;

public record OrderRequest(Long id, String orderNumber, String code, BigDecimal price,Integer quantity) {
}
