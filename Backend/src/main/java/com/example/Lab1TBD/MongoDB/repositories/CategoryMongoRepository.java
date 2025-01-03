package com.example.Lab1TBD.MongoDB.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.Lab1TBD.MongoDB.models.CategoryMongo;

import java.util.Optional;

@Repository
public interface CategoryMongoRepository extends MongoRepository<CategoryMongo, Long> {
    Optional<CategoryMongo> findByName(String name); // Buscar categoría por nombre
}