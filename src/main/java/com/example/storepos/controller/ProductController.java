package com.example.storepos.controller;

import com.example.storepos.dao.ProductDao;
import com.example.storepos.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/products")
@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductDao product;

    @PostMapping("/addproduct")
    public ProductEntity addProduct(@RequestBody ProductEntity product) {
        return this.product.addProduct(product);
    }

    @PostMapping("/updateproduct")
    public ProductEntity updateProduct(@RequestBody ProductEntity product) {
        return this.product.updateProduct(product);
    }

    @GetMapping("/deleteproduct")
    public String deleteProduct(@RequestParam Integer productid) {
        this.product.deleteProduct(productid);
        return "Success";
    }

    @GetMapping("/getbyproductbarcode")
    public ProductEntity getProductByBarcode(@RequestParam String barcode) {
        return this.product.getProductByBarcode(barcode);
    }

    @GetMapping("/getbyproductid")
    public ProductEntity getProductById(@RequestParam Integer id) {
        return this.product.getProductById(id);
    }

    @GetMapping("getallproducts")
    public List<ProductEntity> getAllProducts(){
        return this.product.getAllProducts();
    }
}
