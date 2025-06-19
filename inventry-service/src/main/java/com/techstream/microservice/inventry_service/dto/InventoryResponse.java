package com.techstream.microservice.inventry_service.dto;

import java.math.BigDecimal;


public class InventoryResponse {
    private Long id;

    private String code;

    private Integer quantity;

    public InventoryResponse(Long id, String code, Integer quantity) {
        this.id = id;
        this.code = code;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
