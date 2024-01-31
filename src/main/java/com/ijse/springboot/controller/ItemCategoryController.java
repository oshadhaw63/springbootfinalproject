package com.ijse.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.springboot.entity.ItemCategory;
import com.ijse.springboot.service.ItemCategoryService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
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
