package com.GustavoBoer.ecom_proj.service;

import com.GustavoBoer.ecom_proj.model.Product;
import com.GustavoBoer.ecom_proj.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }
}
