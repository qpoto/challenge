package com.lydiasystems.challenge.entity.DTO;

import com.lydiasystems.challenge.entity.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {
    private String name;
    private String description;
    private BigDecimal price;

    public ProductDTO(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public static ProductDTO fromEntity(Product product) {
        return new ProductDTO(product.getName(), product.getDescription(), product.getPrice());
    }
}
