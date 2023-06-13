package com.codecool.elproyectegrande.controller;


import com.codecool.elproyectegrande.controller.dto.NewProductDTO;
import com.codecool.elproyectegrande.controller.dto.ProductDTO;
import com.codecool.elproyectegrande.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDTO> getAllProducts(){
       return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductDTO getProductByID(@PathVariable String id){
        return productService.getProductByID(Integer.parseInt(id));
    }
    @PostMapping
    public void addNewProduct(@RequestBody NewProductDTO productDTO){
        productService.addNewProduct(productDTO);
    }
}
