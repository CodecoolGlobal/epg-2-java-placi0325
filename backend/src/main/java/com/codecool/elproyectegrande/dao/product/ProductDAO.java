package com.codecool.elproyectegrande.dao.product;

import com.codecool.elproyectegrande.dao.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Long> {
    Product findProductById(Long id);
}
