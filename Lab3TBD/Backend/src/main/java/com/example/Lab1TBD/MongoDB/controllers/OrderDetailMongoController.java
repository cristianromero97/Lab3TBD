package com.example.Lab1TBD.MongoDB.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Lab1TBD.MongoDB.services.OrderDetailMongoService;
import com.example.Lab1TBD.MongoDB.models.OrderDetailMongo;
import java.util.List;

@RestController
@RequestMapping("/api/order-details")
public class OrderDetailMongoController {

    @Autowired
    private OrderDetailMongoService orderDetailService;

    // Obtener todos los detalles de orden
    @GetMapping
    public List<OrderDetailMongo> getAllOrderDetails() {
        return orderDetailService.getAllOrderDetails();
    }

    // Obtener detalle por ID
    @GetMapping("/{id}")
    public OrderDetailMongo getOrderDetailById(@PathVariable Long id) {
        return orderDetailService.getOrderDetailById(id);
    }

    // Guardar un detalle de orden
    @PostMapping
    public OrderDetailMongo saveOrderDetail(@RequestBody OrderDetailMongo orderDetail) {
        return orderDetailService.saveOrderDetail(orderDetail);
    }

    // Buscar detalles por ID de la orden
    @GetMapping("/order/{orderId}")
    public List<OrderDetailMongo> getOrderDetailsByOrderId(@PathVariable String orderId) {
        return orderDetailService.getOrderDetailsByOrderId(orderId);
    }

    // Buscar detalles por ID del producto
    @GetMapping("/product/{productId}")
    public List<OrderDetailMongo> getOrderDetailsByProductId(@PathVariable String productId) {
        return orderDetailService.getOrderDetailsByProductId(productId);
    }

    // Eliminar detalle por ID
    @DeleteMapping("/{id}")
    public void deleteOrderDetail(@PathVariable Long id) {
        orderDetailService.deleteOrderDetail(id);
    }
}
