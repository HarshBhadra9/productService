package org.example.productservices.services;

import org.example.productservices.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long productid);
    List<Product> getAllProducts();
    Product createProduct(String title,
                          String description,
                          String category,
                          double price,
                           String image);


}
