package com.ijse.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ijse.springboot.entity.Stock;
import com.ijse.springboot.service.StockService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/stocks")
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @PostMapping("/stocks")
    public Stock addStock(@RequestBody Stock stock) {
        return stockService.addStock(stock);
    }

    @GetMapping("/stocks/{id}")
    public Stock getStockById(@PathVariable Long id) {
        return stockService.getStockById(id);
    }
}
