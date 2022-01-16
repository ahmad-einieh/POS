package com.example.storepos.dao;

import com.example.storepos.dto.OrderDto;
import com.example.storepos.entity.OrderEntity;
import com.example.storepos.entity.SaleEntity;
import com.example.storepos.repository.SaleRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleDao {

    @Autowired
    private SaleRep saleRep;

    private OrderDao orderDao;

    public SaleDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public OrderEntity saveSale(List<OrderDto> orderList) {
        if (orderList.size() == 0) return null;
        OrderEntity ord = this.orderDao.saveOrder(orderList);
        orderList.forEach(o -> {
            SaleEntity sale = new SaleEntity();
            sale.setOrderid(ord.getOrderid());
            sale.setProductid(o.getProductid());
            this.saleRep.save(sale);
        });
        return ord;
    }

    public List<SaleEntity> getAllSales(){
        return this.saleRep.findAll();
    }

    public List<SaleEntity> getAllSalesByOrderId(Integer orderid){
        return this.saleRep.findAllByOrderid(orderid);
    }

}
