package com.example.Lab1TBD.MongoDB.controllers;

import com.example.Lab1TBD.MongoDB.services.ProductMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Lab1TBD.MongoDB.models.ProductMongo;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductMongoController {

    @Autowired
    private ProductMongoService productService;

    @GetMapping
    public List<ProductMongo> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductMongo getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductMongo saveProduct(@RequestBody ProductMongo product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<String> getProductImage(@PathVariable Long id) {
        try {
            ProductMongo product = productService.getProductById(id);
            if (product == null || product.getImages() == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Imagen no encontrada.");
            }
            return ResponseEntity.ok(product.getImages());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al buscar la imagen.");
        }
    }

}
