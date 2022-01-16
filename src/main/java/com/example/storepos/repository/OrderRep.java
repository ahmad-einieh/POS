package com.example.storepos.repository;

import com.example.storepos.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRep extends JpaRepository<OrderEntity,Integer> {
}
