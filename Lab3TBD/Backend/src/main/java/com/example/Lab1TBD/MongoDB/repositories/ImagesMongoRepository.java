package com.example.Lab1TBD.MongoDB.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.Lab1TBD.MongoDB.models.ImagesMongo;

import java.util.List;

@Repository
public interface ImagesMongoRepository extends MongoRepository<ImagesMongo, Long> {
    List<ImagesMongo> findByProductId(Long productId);
}
