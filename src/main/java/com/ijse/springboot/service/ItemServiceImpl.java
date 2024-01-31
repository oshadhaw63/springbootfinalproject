package com.ijse.springboot.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.springboot.dto.ItemDTO;
import com.ijse.springboot.entity.Item;
import com.ijse.springboot.entity.ItemCategory;
import com.ijse.springboot.repository.ItemCategoryRepository;
import com.ijse.springboot.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item createItem(ItemDTO itemDTO) {
        ItemCategory itemCategory = itemCategoryRepository.findById(itemDTO.getItemCategoryId()).orElse(null);

        if (itemCategory != null) {
            Item item = new Item();
            item.setName(itemDTO.getName());
            item.setPrice(itemDTO.getPrice());
            item.setQuantity(itemDTO.getQuantity());
            item.setItemCategory(itemCategory);

            return itemRepository.save(item);
        } else {
            return null;
        }
    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public Item updateItem(Long id, ItemDTO itemDTO) {
        Item existingItem = itemRepository.findById(id).orElse(null);

        if (existingItem != null) {
            existingItem.setName(itemDTO.getName());
            existingItem.setPrice(itemDTO.getPrice());
            existingItem.setQuantity(itemDTO.getQuantity());
            existingItem.setItemCategory(itemCategoryRepository.findById(itemDTO.getItemCategoryId()).orElse(null));

            return itemRepository.save(existingItem);
        } else {
            return null;
        }
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public List<Item> getItemsByCategory(Long categoryId) {
        ItemCategory itemCategory = itemCategoryRepository.findById(categoryId).orElse(null);

        if (itemCategory != null) {
            return itemRepository.findByItemCategory(itemCategory);
        } else {
            return null;
        }
    }


}

