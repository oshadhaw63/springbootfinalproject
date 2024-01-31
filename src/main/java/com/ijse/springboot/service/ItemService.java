package com.ijse.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.springboot.dto.ItemDTO;
import com.ijse.springboot.entity.Item;

@Service
public interface ItemService {
    List<Item> getAllItems();
    Item createItem(Item item);
    static Item getItemById(Long id) {

        throw new UnsupportedOperationException("Unimplemented method 'getItemById'");
    }
    Item updateItem(Long id, ItemDTO itemDTO);
    void deleteItem(Long id);
    List<Item> getItemsByCategory(Long categoryId);
    
}