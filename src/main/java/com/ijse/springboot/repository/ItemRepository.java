package com.ijse.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.springboot.entity.Item;
import com.ijse.springboot.entity.ItemCategory;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAll();

    Item save(Item item);

    Optional<Item> findById(Long id);

    List<Item> findByItemCategory(ItemCategory itemCategory);
}
