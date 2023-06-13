package com.codecool.elproyectegrande.service;

import com.codecool.elproyectegrande.controller.dto.NewProductDTO;
import com.codecool.elproyectegrande.controller.dto.ProductDTO;
import com.codecool.elproyectegrande.dao.model.Product;
import com.codecool.elproyectegrande.dao.product.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService implements ProductDAO {
    
    @Autowired
    public ProductService() {
        
    }

    /*@Override
    public List<ProductDTO> getAllProducts() {
        return products.stream().map(this::convertProductToDTO).toList();
    }

    @Override
    public ProductDTO getProductByID(int id) {
        return convertProductToDTO(products.stream().filter(product -> product.getId() == id).findFirst().orElseThrow(NoSuchElementException::new));
    }

    @Override
    public void addNewProduct(NewProductDTO product) {
        products.add(convertDTOtoProduct(product));
    }

    private Product convertDTOtoProduct(NewProductDTO productDTO) {
        return new Product(products.size(), productDTO.name(), productDTO.description(), productDTO.userID(), productDTO.price());
    }

    private ProductDTO convertProductToDTO(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getUserID(), product.getPrice());
    }*/
}