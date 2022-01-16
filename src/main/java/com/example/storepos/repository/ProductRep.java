package com.example.storepos.repository;

import com.example.storepos.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRep extends JpaRepository<ProductEntity,Integer> {


    ProductEntity findByBarcode(String barcode);
}
