package com.example.storepos.controller;

import com.example.storepos.dao.OrderDao;
import com.example.storepos.dao.SaleDao;
import com.example.storepos.dto.OrderDto;
import com.example.storepos.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/orders")
@RestController
public class OrderController {

    @Autowired
    private OrderDao order;

    @Autowired
    private SaleDao saleDao;

    @PostMapping (path = "saveorder")
    public OrderEntity saveOrder(@RequestBody List<OrderDto> orderList){
        return this.saleDao.saveSale(orderList);
    }


    @GetMapping(path = "getallorders")
    public List<OrderEntity> getAllOrders(){
        return this.order.getAllOrders();
    }


}
