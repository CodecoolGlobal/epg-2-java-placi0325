package com.codecool.elproyectegrande.service;

import com.codecool.elproyectegrande.controller.dto.NewProductDTO;
import com.codecool.elproyectegrande.dao.model.Product;
import com.codecool.elproyectegrande.dao.product.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductDAO productDAO;

    @Autowired
    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }


    public List<Product> getAllProducts() {
        return productDAO.findAll();
    }


    public Product getProductByID(Long id) {
        return productDAO.getById(id);
    }

    public void addNewProduct(NewProductDTO product) {
        Product newProduct = Product.builder()
                .name(product.name())
                .description(product.description())
                .seller(product.seller())
                .price(product.price())
                .buyer(product.buyer())
                .build();
        productDAO.save(newProduct);
    }

    public void updateProductByID(Long id, Product updateProduct){
        Product currentProduct = getProductByID(id);
        if (updateProduct.getName() != null) currentProduct.setName(updateProduct.getName());
        if (updateProduct.getDescription() != null) currentProduct.setDescription(updateProduct.getDescription());
        if (updateProduct.getSeller() != null) currentProduct.setSeller(updateProduct.getSeller());
        if (updateProduct.getPrice() != 0) currentProduct.setPrice(updateProduct.getPrice());
        if (updateProduct.getBuyer() != null) currentProduct.setBuyer(updateProduct.getBuyer());
    }

    public void deleteProductByID(Long id){
        productDAO.deleteById(id);
    }
}

