package org.example.productservices.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    
    private String title;
    @OneToMany(mappedBy = "category")
    private List<Product> products;


}
