package org.example.productservices.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.productservices.dtos.fakestoreProductDto;
import org.example.productservices.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
@Getter
@Setter


public class FakeStoreProductService implements ProductService{
    //RestTemplate
    // - allows to send HTTP request
    // and work with responses.

    private RestTemplate restTemplate;
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }



    @Override
    public Product getSingleProduct(Long productid) {
        fakestoreProductDto fakeStoreProduct = restTemplate.getForObject("https://fakestoreapi.com/products/" + productid,
                fakestoreProductDto.class
        );
        return fakeStoreProduct.toProduct();
    }


    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(String title, String description, String category, double price, String image) {
        fakestoreProductDto fakeStoreProductDto = new fakestoreProductDto();
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(image);
        fakestoreProductDto response = restTemplate.postForObject("https://fakestoreapi.com/products" ,fakeStoreProductDto,
                fakestoreProductDto.class
        );

        return response.toProduct();

    }
}
