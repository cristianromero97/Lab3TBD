package com.example.Lab1TBD.MongoDB.services;

import com.example.Lab1TBD.persistence.entities.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Lab1TBD.MongoDB.models.ProductMongo;
import com.example.Lab1TBD.MongoDB.repositories.ProductMongoRepository;

import java.util.List;

@Service
public class ProductMongoService {
    @Autowired
    private ProductMongoRepository productMongoRepository;

    // Obtener todos los productos
    public List<ProductMongo> getAllProducts() {
        return productMongoRepository.findAll();
    }

    // Buscar por ID
    public ProductMongo getProductById(Long id) {
        return productMongoRepository.findById(id).orElse(null);
    }

    // Guardar un producto
    public ProductMongo saveProduct(ProductMongo product) {
        return productMongoRepository.save(product);
    }

    // Eliminar un producto
    public void deleteProduct(Long id) {
        productMongoRepository.deleteById(id);
    }

}
