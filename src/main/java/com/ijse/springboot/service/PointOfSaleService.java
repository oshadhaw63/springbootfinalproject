package com.ijse.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.springboot.dto.AddToCartRequest;
import com.ijse.springboot.dto.UpdateStockRequest;
import com.ijse.springboot.entity.CartItem;
import com.ijse.springboot.entity.Invoice;
import com.ijse.springboot.entity.Item;
import com.ijse.springboot.entity.PointOfSaleTransaction;
import com.ijse.springboot.repository.PointOfSaleTransactionRepository;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class PointOfSaleService {

    @Autowired
    private PointOfSaleTransactionRepository transactionRepository;

    @Autowired
    private ItemService itemService;
    
    @Autowired
    private CartService cartService;

    @Autowired
    private StockService stockService;

    public List<PointOfSaleTransaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public void addToCart(AddToCartRequest addToCartRequest) {
        Item item = ItemService.getItemById(addToCartRequest.getItemId());
        CartItem cartItem = new CartItem();
        cartItem.setItemId(addToCartRequest.getItemId());
        cartItem.setQuantity(addToCartRequest.getQuantity());
        cartService.addToCart(cartItem);
    }

    public void updateStock(UpdateStockRequest updateStockRequest) {
        StockService.updateStock(updateStockRequest.getItemId(), updateStockRequest.getQuantitySold());
    }

    public Long generateInvoice(List<CartItem> cartItems) {
        Invoice invoice = new Invoice();
        invoice.setItems(cartItems);
        invoice.setTotalAmount(calculateTotalAmount(cartItems));

        Invoice savedInvoice = Invoice.save(invoice);
        return savedInvoice.getId();
    }

    private double calculateTotalAmount(List<CartItem> cartItems) {
        double totalAmount = 0.0;

        for (CartItem cartItem : cartItems) {
            Item item = ItemService.getItemById(cartItem.getItemId());
            double itemPrice = item.getPrice();
            double itemTotal = itemPrice * cartItem.getQuantity();
            totalAmount += itemTotal;
        }

        return totalAmount;
    }

    public void addToCart(Long itemId, int quantity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addToCart'");
    }

    public void updateStock(Long itemId, int quantity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateStock'");
    }
}
