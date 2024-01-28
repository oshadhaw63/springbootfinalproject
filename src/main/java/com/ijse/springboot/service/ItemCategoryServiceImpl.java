package com.ijse.springboot.service;


import com.ijse.springboot.entity.ItemCategory;
import com.ijse.springboot.repository.ItemCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
}
