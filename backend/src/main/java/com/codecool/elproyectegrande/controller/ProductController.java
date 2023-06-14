package com.codecool.elproyectegrande.controller;


import com.codecool.elproyectegrande.controller.dto.NewProductDTO;
import com.codecool.elproyectegrande.dao.model.Product;
import com.codecool.elproyectegrande.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/orderedBy")
    public ResponseEntity<?> getProductsOrderedByName(@RequestParam String propertyName, @RequestParam(defaultValue = "asc") String sortOrder) {

        switch (propertyName){
            case "name":  return ResponseEntity.ok().body(productService.getAllProductsOrderedByName(sortOrder));
            case "price": return ResponseEntity.ok().body(productService.getAllProductsOrderedByPrice(sortOrder));
            default:  return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }


        /*if (propertyName.equals("name")) {
            return ResponseEntity.ok().body(productService.getAllProductsOrderedByName(sortOrder));
        } else if (propertyName.equals("price")) {
            return ResponseEntity.ok().body(productService.getAllProductsOrderedByPrice(sortOrder));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();*/
    }

     /*@GetMapping("/available")
    public List<Product> getAvailableProducts(){
       return productService.getAllAvailableProducts();
    }*/

    @GetMapping("/{id}")
    public Product getProductByID(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ResponseEntity addNewProduct(@RequestBody NewProductDTO productDTO) {
        productService.addNewProduct(productDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public void updateProductById(@PathVariable("id") Long id, @RequestBody Product updatedProduct) {
        productService.updateProductById(id, updatedProduct);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
    }

}
