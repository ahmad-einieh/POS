package com.example.storepos.controller;

import com.example.storepos.dao.SaleDao;
import com.example.storepos.entity.SaleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(path = "/sales")
@RestController
public class SaleController {

    @Autowired
    private SaleDao sale;


    @GetMapping(path = "getallsales")
    public List<SaleEntity> getAllSales(){
        return this.sale.getAllSales();
    }

    @GetMapping(path = "getallsalesbyorderid")
    public List<SaleEntity> getAllSalesByOrderId(@RequestParam Integer orderid){
        return this.sale.getAllSalesByOrderId(orderid);
    }


}
