package com.example.storepos.repository;

import com.example.storepos.entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SaleRep extends JpaRepository<SaleEntity,Integer> {

    List<SaleEntity> findAllByOrderid(Integer orderid);
}
