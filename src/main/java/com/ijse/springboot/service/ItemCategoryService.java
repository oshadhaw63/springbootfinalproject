package com.ijse.springboot.service;


import com.ijse.springboot.entity.ItemCategory;

import java.util.List;

public interface ItemCategoryService {
    List<ItemCategory> getAllCategories();
    ItemCategory getCategoryById(Long id);
    ItemCategory createCategory(ItemCategory category);
    List<ItemCategory> getAllItemCategories();
    ItemCategory createItemCategory(ItemCategory itemCategory);
    ItemCategory getItemCategoryById(Long id);
    
}


