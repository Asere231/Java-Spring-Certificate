package com.example.sprinecom.service;

import com.example.sprinecom.model.Product;
import com.example.sprinecom.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    public Product getProduct(int id) {
        return productRepo.findById(id).orElseThrow(() -> new RuntimeException("Not found!!!"));
    }

    public Product addOrUpdateProduct(Product product, MultipartFile image) {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        try {
            product.setImageData(image.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return productRepo.save(product);
    }

    public void deleteProduct(int id) {
        productRepo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {
        return productRepo.searchProducts(keyword);
    }

//    public Product updateProduct(Product product, MultipartFile imageFile) {
//
//        product.setImageName(imageFile.getOriginalFilename());
//        product.setImageType(imageFile.getContentType());
//        try {
//            product.setImageData(imageFile.getBytes());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        return productRepo.save(product);
//    }
}
