package com.lydiasystems.challenge.repository;

import com.lydiasystems.challenge.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
