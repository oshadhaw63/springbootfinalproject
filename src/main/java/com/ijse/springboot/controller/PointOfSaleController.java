package com.ijse.springboot.controller;


import com.ijse.springboot.dto.AddToCartRequest;
import com.ijse.springboot.dto.GenerateInvoiceRequest;
import com.ijse.springboot.dto.UpdateStockRequest;
import com.ijse.springboot.entity.CartItem;
import com.ijse.springboot.entity.PointOfSaleTransaction;
import com.ijse.springboot.service.PointOfSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PointOfSaleController {

    @Autowired
    private PointOfSaleService pointOfSaleService;

    @GetMapping("/point-of-sale/transactions")
    public List<PointOfSaleTransaction> getAllTransactions() {
        return pointOfSaleService.getAllTransactions();
    }

    @PostMapping("/point-of-sale/add-to-cart")
    public ResponseEntity<?> addToCart(@RequestBody AddToCartRequest addToCartRequest) {
        try {

            Long itemId = addToCartRequest.getItemId();
            int quantity = addToCartRequest.getQuantity();

            pointOfSaleService.addToCart(itemId, quantity);

            pointOfSaleService.updateStock(itemId, quantity);

            return ResponseEntity.ok().body("Items added to the cart successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to add items to the cart: " + e.getMessage());
        }
    }

    @PostMapping("/point-of-sale/generate-invoice")
    public ResponseEntity<?> generateInvoice(@RequestBody GenerateInvoiceRequest generateInvoiceRequest) {
        try {
    
            List<CartItem> cartItems = generateInvoiceRequest.getCartItems();

            Long invoiceId = pointOfSaleService.generateInvoice(cartItems);

            return ResponseEntity.ok().body("Invoice generated successfully. Invoice ID: " + invoiceId);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to generate invoice: " + e.getMessage());
        }
    }

    @PostMapping("/point-of-sale/update-stock")
    public ResponseEntity<?> updateStock(@RequestBody UpdateStockRequest updateStockRequest) {
        try {

            Long itemId = updateStockRequest.getItemId();
            int quantitySold = updateStockRequest.getQuantitySold();

            pointOfSaleService.updateStock(itemId, quantitySold);

            return ResponseEntity.ok().body("Stock updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to update stock: " + e.getMessage());
        }
    }
}
