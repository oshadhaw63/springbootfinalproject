package com.ijse.springboot.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.ijse.springboot.entity.CartItem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Invoice {
    private Long id;

    private List<CartItem> items;
    private Double totalAmount;
    private LocalDateTime date;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
