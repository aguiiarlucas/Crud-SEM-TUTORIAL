package com.example.crud.meu.crud.DTO;


import com.example.crud.meu.crud.entities.Product;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {


    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @DecimalMin(value = "0.01")
    private BigDecimal price;


    public ProductDTO(Product product) {
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        price = BigDecimal.valueOf(product.getPrice());
    }
}
