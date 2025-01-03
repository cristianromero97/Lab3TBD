package com.example.Lab1TBD.MongoDB.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.Lab1TBD.MongoDB.models.OrderDetailMongo;
import java.util.List;

@Repository
public interface OrderDetailMongoRepository extends MongoRepository<OrderDetailMongo, Long> {
    List<OrderDetailMongo> findByOrderId(String orderId);     // Buscar detalles por ID de la orden
    List<OrderDetailMongo> findByProductId(String productId); // Buscar detalles por ID del producto
}
