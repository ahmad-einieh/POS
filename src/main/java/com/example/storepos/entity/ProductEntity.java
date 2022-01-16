package com.example.storepos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private Integer productid;
    @Column(name = "productname")
    private String productname;
    @Column(name = "productprice")
    private Double productprice;
    @Column(name = "barcode")
    private String barcode;


    @JsonBackReference
    @OneToOne(mappedBy = "product")
    @JoinColumn(name = "productid",insertable = false,updatable = false)
    private SaleEntity sale;
}
