package com.ijse.springboot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UpdateStockRequest {
    private Long itemId;
    private int quantitySold;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }

}
