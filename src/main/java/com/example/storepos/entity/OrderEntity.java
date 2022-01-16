package com.example.storepos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@Data
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private Integer orderid;
    @Column(name = "total")
    private Double total;


   /* @JsonBackReference // here
    @OneToOne(mappedBy = "order")
    @JoinColumn(name = "orderid",insertable = false,updatable = false)
    private SaleEntity sale;*/

}
