package com.example.storepos.dao;

import com.example.storepos.entity.ProductEntity;
import com.example.storepos.repository.ProductRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDao {
    @Autowired
    private ProductRep product;

    public ProductEntity addProduct(ProductEntity product) {
        return this.product.save(product);
    }

    public ProductEntity updateProduct(ProductEntity product) {
        return this.product.save(product);
    }

    public void deleteProduct(Integer productid) {
        this.product.deleteById(productid);
    }

    public ProductEntity getProductByBarcode(String barcode) {
        Optional<ProductEntity> o = Optional.ofNullable(this.product.findByBarcode(barcode));
        return o.isPresent() ? o.get() : null;
    }

    public ProductEntity getProductById(Integer id) {
        Optional<ProductEntity> o = this.product.findById(id);
        return o.isPresent() ? o.get() : null;
    }

    public List<ProductEntity> getAllProducts(){
        return this.product.findAll();
    }

}
