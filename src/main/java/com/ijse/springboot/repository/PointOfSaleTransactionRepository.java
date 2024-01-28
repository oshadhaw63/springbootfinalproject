package com.ijse.springboot.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.springboot.entity.PointOfSaleTransaction;

import java.util.List;

@Repository
public interface PointOfSaleTransactionRepository extends JpaRepository<PointOfSaleTransaction, Long> {
    
    List<PointOfSaleTransaction> findByUserId(Long userId);

}
