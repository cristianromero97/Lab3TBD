package com.example.Lab1TBD.MongoDB.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.Lab1TBD.MongoDB.models.OrderMongo;

import java.util.List;

@Repository
public interface OrderMongoRepository extends MongoRepository<OrderMongo, Long> {
    // Busca las ordenes de un cliente en especifico.
    List<OrderMongo> findByClientId(Long clientId);
}
