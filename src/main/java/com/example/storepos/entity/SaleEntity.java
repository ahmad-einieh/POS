package com.example.storepos.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "sales")
@Data
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "saleid")
    private Integer salseid;
    @Column(name = "productid")
    private Integer productid;
    @Column(name = "orderid")
    private Integer orderid;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "productid",insertable = false,updatable = false)
    private ProductEntity product;

    /*@JsonManagedReference
    @OneToOne
    @JoinColumn(name = "orderid",insertable = false,updatable = false)
    private OrderEntity order;*/

}
