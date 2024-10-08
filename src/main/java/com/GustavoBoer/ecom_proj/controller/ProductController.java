package com.GustavoBoer.ecom_proj.controller;

import com.GustavoBoer.ecom_proj.model.Product;
import com.GustavoBoer.ecom_proj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK) ;
    }

    @GetMapping("product/{id}")
    public ResponseEntity<Product> getProd(@PathVariable int id){
        Product prod = service.getProductbyId(id);
        if(prod != null)
            return new ResponseEntity<>(service.getProductbyId(id), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
