package com.example.storepos.dao;


import com.example.storepos.dto.OrderDto;
import com.example.storepos.entity.OrderEntity;
import com.example.storepos.repository.OrderRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDao {
    @Autowired
    private OrderRep order;

    public OrderEntity saveOrder(List<OrderDto> orderList){
        Double total = 0.0;
        for ( OrderDto o : orderList){
            total += o.getProductprice();
        }
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setTotal(total);
        return this.order.save(orderEntity);
    }

    public List<OrderEntity> getAllOrders(){
        return this.order.findAll();
    }

}
