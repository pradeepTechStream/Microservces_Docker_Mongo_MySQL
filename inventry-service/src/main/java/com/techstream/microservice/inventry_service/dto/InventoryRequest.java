package com.techstream.microservice.inventry_service.dto;

import java.math.BigDecimal;

public record InventoryRequest(Long id, String skuCode,Integer quantity) {
}
