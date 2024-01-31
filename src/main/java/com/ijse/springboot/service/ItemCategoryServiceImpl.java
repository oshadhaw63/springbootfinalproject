package com.ijse.springboot.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.springboot.entity.ItemCategory;
import com.ijse.springboot.repository.ItemCategoryRepository;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService{

    private final ItemCategoryRepository categoryRepository;

    @Autowired
    public ItemCategoryServiceImpl(ItemCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<ItemCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public ItemCategory getCategoryById(Long id) {
        Optional<ItemCategory> optionalCategory = categoryRepository.findById(id);
        return optionalCategory.orElse(null);
    }

    @Override
    public ItemCategory createCategory(ItemCategory category) {
        
        return categoryRepository.save(category);
    }

    private void validateCategory(ItemCategory category) {
        if (category.getName() == null || category.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Category name cannot be empty");
        }
    }

    @Override
    public List<ItemCategory> getAllItemCategories() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllItemCategories'");
    }

    @Override
    public ItemCategory createItemCategory(ItemCategory itemCategory) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createItemCategory'");
    }

    @Override
    public ItemCategory getItemCategoryById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getItemCategoryById'");
    }
}
