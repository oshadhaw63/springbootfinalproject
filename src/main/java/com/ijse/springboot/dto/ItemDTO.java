package com.ijse.springboot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {

    private Long id;
    private String name;
    private double price;
    public int getQuantity() {
        throw new UnsupportedOperationException("Unimplemented method 'getQuantity'");
    }
    public Long getItemCategoryId() {
        throw new UnsupportedOperationException("Unimplemented method 'getItemCategoryId'");
    }
}
        
