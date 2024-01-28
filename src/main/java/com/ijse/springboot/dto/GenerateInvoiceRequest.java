package com.ijse.springboot.dto;
import java.util.List;

import com.ijse.springboot.entity.CartItem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenerateInvoiceRequest {
    private List<CartItem> cartItems;

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

}
