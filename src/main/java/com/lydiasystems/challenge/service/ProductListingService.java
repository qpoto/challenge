package com.lydiasystems.challenge.service;

import com.lydiasystems.challenge.entity.DTO.ProductDTO;
import com.lydiasystems.challenge.entity.Product;
import com.lydiasystems.challenge.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductListingService {

    private final ProductRepository productRepository;

    public Map<ProductDTO, Long> getAllProducts() {
        List<ProductDTO> products = productRepository.findAll().stream().map(ProductDTO::fromEntity)
                .collect(Collectors.toList());;

        return products.stream()
                .collect(Collectors.groupingBy(product -> product, Collectors.counting()));
    }
}
