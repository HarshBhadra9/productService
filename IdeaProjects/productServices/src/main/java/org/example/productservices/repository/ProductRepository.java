package org.example.productservices.repository;

import org.example.productservices.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product save(Product product);
}
