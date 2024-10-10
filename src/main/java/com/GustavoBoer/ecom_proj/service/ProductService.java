package com.GustavoBoer.ecom_proj.service;

import com.GustavoBoer.ecom_proj.model.Product;
import com.GustavoBoer.ecom_proj.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    public Product getProductbyId(int id) {
        return  repo.findById(id).orElse(null);
    }

    public Product addProduct(Product prod, MultipartFile imageFile) throws IOException {
        prod.setImageName(imageFile.getOriginalFilename());
        prod.setImageType(imageFile.getContentType());
        prod.setImageData(imageFile.getBytes());
        return repo.save(prod);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        product.setImageData(imageFile.getBytes());
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        return repo.save(product);
        
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);

    }
}
