package com.ijse.springboot.service;

import com.ijse.springboot.dto.StockDTO;
import com.ijse.springboot.entity.Stock;

import java.util.List;

public interface StockService {
    List<Stock> getAllStocks();
    Stock getStockById(Long id);
    Stock updateStock(StockDTO stockDTO);
    void deleteStock(Long id);
    Stock addStock(Stock stock);
    static void updateStock(Long itemId, int quantitySold) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateStock'");
    }
}
