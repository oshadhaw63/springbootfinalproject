package com.ijse.springboot.service;
import org.springframework.stereotype.Service;

import com.ijse.springboot.entity.CartItem;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    private static List<CartItem> cartItems = new ArrayList<>();

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public static void addToCart(CartItem cartItem) {

        for (CartItem item : cartItems) {
            if (item.getItemId().equals(cartItem.getItemId())) {

                item.setQuantity(item.getQuantity() + cartItem.getQuantity());
                return;
            }
        }

        cartItems.add(cartItem);
    }

    public void clearCart() {
        cartItems.clear();
    }

    public double calculateTotalAmount() {
        double totalAmount = 0.0;
        for (CartItem item : cartItems) {
            totalAmount += item.getPrice() * item.getQuantity();
        }
        return totalAmount;
    }
}
