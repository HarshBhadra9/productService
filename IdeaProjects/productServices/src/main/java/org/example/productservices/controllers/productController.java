package org.example.productservices.controllers;


import lombok.Getter;
import lombok.Setter;
import org.example.productservices.dtos.CreateProductRequestDto;
import org.example.productservices.models.Product;
import org.example.productservices.repository.ProductRepository;
import org.example.productservices.services.ProductService;
import org.springframework.web.bind.annotation.*;
@Getter
@Setter
@RestController
public class productController {

    // POST /products
    // RequestBody
    // {
    //    title:
    //    description:
    //    price:
    // }
    private ProductService productService;
    private ProductRepository productRepository;
    public productController(ProductRepository productRepository,ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }
    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDto request) {

        Product newProduct = new Product();
        newProduct.setDescription(request.getDescription());
        newProduct.setPrice(request.getPrice());
        newProduct.setImageUrl(request.getImage());
        newProduct.setTitle(request.getTitle());

        newProduct = productRepository.save(newProduct);





        return productService.createProduct(
                request.getTitle(),
                request.getDescription(),
                request.getCategory(),
                request.getPrice(),
                request.getImage()
        );


    }

   // Get /products/1
    // Get /products/201
    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") Long productId){
        return productService.getSingleProduct(productId);
    }
    @GetMapping("/products")
    public void getAllProducts(){

    }

    public void updateProducts(){

    }

}
