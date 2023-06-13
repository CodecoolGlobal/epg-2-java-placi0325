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

    private final List<Product> products;

    @Autowired
    public ProductService() {
        this.products = List.of(
                new Product(1, "Vintage Leather Jacket", "Genuine leather jacket with a vintage look and feel.", 20, 99.99),
                new Product(2, "Antique Pocket Watch", "Beautifully crafted pocket watch from the early 1900s.", 1, 149.99),
                new Product(3, "Handcrafted Wooden Table", "Unique wooden table carved by skilled artisans.", 2, 299.99),
                new Product(4, "Vintage Vinyl Records", "Collection of classic vinyl records from various artists.", 3, 24.99),
                new Product(5, "Retro Polaroid Camera", "Vintage instant camera that captures timeless moments.", 4, 79.99),
                new Product(6, "Antique Brass Key", "Intricately designed antique key made of solid brass.", 5, 9.99),
                new Product(7, "Handwoven Tapestry", "Colorful tapestry woven by skilled artisans.", 6, 59.99),
                new Product(8, "Vintage Tea Set", "Elegant porcelain tea set with delicate floral patterns.", 7, 39.99),
                new Product(9, "Antique Wooden Chest", "Charming wooden chest with ornate carvings.", 8, 199.99),
                new Product(10, "Retro Rotary Phone", "Fully functional rotary phone with a retro design.", 9, 69.99),
                new Product(11, "Vintage Fountain Pen", "Classic fountain pen made with fine craftsmanship.", 10, 49.99),
                new Product(12, "Antique Silver Brooch", "Exquisite brooch adorned with intricate silver details.", 11, 29.99),
                new Product(13, "Hand-Painted Ceramic Vase", "One-of-a-kind ceramic vase painted by a local artist.", 12, 79.99),
                new Product(14, "Vintage Film Camera", "Film camera from the 1970s for capturing nostalgic moments.", 13, 89.99),
                new Product(15, "Antique Oil Lamp", "Elegant oil lamp with a beautifully detailed glass shade.", 14, 119.99),
                new Product(16, "Vintage Leather Suitcase", "Stylish leather suitcase with a retro travel vibe.", 15, 149.99),
                new Product(17, "Antique Brass Candlesticks", "Pair of ornate brass candlesticks with intricate details.", 16, 79.99),
                new Product(18, "Vintage Typewriter", "Classic typewriter perfect for writers and collectors.", 17, 129.99),
                new Product(19, "Handmade Leather Wallet", "Handcrafted leather wallet with multiple card slots.", 18, 49.99),
                new Product(20, "Antique Wooden Bookshelf", "Beautifully aged wooden bookshelf with ample storage.", 19, 299.99)
        );
    }

    @Override
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
    }
}