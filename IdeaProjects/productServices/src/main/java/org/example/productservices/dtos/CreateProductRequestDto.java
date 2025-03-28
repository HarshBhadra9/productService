package org.example.productservices.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

// This class is only responsible for request for create request
public class CreateProductRequestDto {
    private String title;
    private String description;
    private String category;
    private double price;
    private String image;


}
//DTO FOR EACH REQUEST SO THAT IN FUTURE
// IF THE REQUEST NEEDS ADDITIONAL PARAMTERS
// YOU CAN EASILY ADD WITHOUT IMPACT ANYTHING
