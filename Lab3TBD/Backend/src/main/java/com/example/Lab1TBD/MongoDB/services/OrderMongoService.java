package com.example.Lab1TBD.MongoDB.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.Lab1TBD.MongoDB.repositories.OrderMongoRepository;
import com.example.Lab1TBD.MongoDB.models.OrderMongo;
@Service
public class OrderMongoService {
    @Autowired
    private OrderMongoRepository orderRepository;

    // Obtener todas las órdenes
    public List<OrderMongo> getAllOrders() {
        return orderRepository.findAll();
    }

    // Obtener una orden por ID
    public OrderMongo getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    // Guardar una nueva orden
    public OrderMongo createOrder(OrderMongo orderEntity) {
        if (orderRepository.existsById(orderEntity.getId())) {
            return null;
        }
        return orderRepository.save(orderEntity);
    }

    // Actualiza una orden existente.
    public OrderMongo updateOrder(OrderMongo orderEntity) {
        if (orderRepository.existsById(orderEntity.getId())) {
            return orderRepository.save(orderEntity);
        }
        return null;
    }
    
    // Actualiza una orden existente, forzando el uso de una ID existente.
    public OrderMongo updateOrder(OrderMongo orderEntity, Long orderId) {
        if (orderRepository.existsById(orderId)) {
            orderEntity.setId(orderId);
            return orderRepository.save(orderEntity);
        }
        return null;
    }

    // Eliminar una orden por ID
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    public List<OrderMongo> findByClientId(Long clientId) {
        return orderRepository.findByClientId(clientId);
    }
}
