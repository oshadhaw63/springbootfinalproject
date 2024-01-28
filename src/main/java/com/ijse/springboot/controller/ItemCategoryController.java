package com.ijse.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ijse.springboot.entity.ItemCategory;
import com.ijse.springboot.service.ItemCategoryService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ItemCategoryController {

    @Autowired
    private ItemCategoryService itemCategoryService;

    @GetMapping("/item-categories")
    public List<ItemCategory> getAllItemCategories() {
        return itemCategoryService.getAllItemCategories();
    }

    @PostMapping("/item-categories")
    public ItemCategory createItemCategory(@RequestBody ItemCategory itemCategory) {
        return itemCategoryService.createItemCategory(itemCategory);
    }

    @GetMapping("/item-categories/{id}")
    public ItemCategory getItemCategoryById(@PathVariable Long id) {
        return itemCategoryService.getItemCategoryById(id);
    }
}
