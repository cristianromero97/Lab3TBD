package com.example.Lab1TBD.MongoDB.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Lab1TBD.MongoDB.repositories.OrderDetailMongoRepository;
import com.example.Lab1TBD.MongoDB.models.OrderDetailMongo;
import java.util.List;

@Service
public class OrderDetailMongoService {
    @Autowired
    private OrderDetailMongoRepository orderDetailRepository;

    // Obtener todos los detalles de orden
    public List<OrderDetailMongo> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    // Guardar un detalle de orden
    public OrderDetailMongo saveOrderDetail(OrderDetailMongo orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    // Obtener detalle por ID
    public OrderDetailMongo getOrderDetailById(Long id) {
        return orderDetailRepository.findById(id).orElse(null);
    }

    // Buscar detalles por ID de la orden
    public List<OrderDetailMongo> getOrderDetailsByOrderId(String orderId) {
        return orderDetailRepository.findByOrderId(orderId);
    }

    // Buscar detalles por ID del producto
    public List<OrderDetailMongo> getOrderDetailsByProductId(String productId) {
        return orderDetailRepository.findByProductId(productId);
    }

    // Eliminar detalle de orden
    public void deleteOrderDetail(Long id) {
        orderDetailRepository.deleteById(id);
    }
}
