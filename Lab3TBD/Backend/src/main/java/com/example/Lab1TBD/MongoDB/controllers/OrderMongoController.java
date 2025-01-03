package com.example.Lab1TBD.MongoDB.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Lab1TBD.MongoDB.models.OrderMongo;
import com.example.Lab1TBD.MongoDB.services.OrderMongoService;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderMongoController {

    @Autowired
    private OrderMongoService orderService;

    // Obtener todas las órdenes
    @GetMapping("/")
    public ResponseEntity<List<OrderMongo>> getAllOrders() {
        List<OrderMongo> found = orderService.getAllOrders();
        return found.isEmpty()? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.ok(found);
    }

    // Obtener una orden por ID
    @GetMapping("/{id}")
    public ResponseEntity<OrderMongo> getOrderById(@PathVariable("id") Long orderId) {
        OrderMongo found = orderService.getOrderById(orderId);
        return found == null? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.ok(found);
    }

    // Obtener Ordenes por el ID del cliente.
    @GetMapping("/client/{id}")
    public ResponseEntity<List<OrderMongo>> findByClientId(@PathVariable("id") Long orderId) {
        List<OrderMongo> orders = orderService.findByClientId(orderId);
        return orders.isEmpty() ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.ok(orders);
    }

    // Crear una nueva orden
    @PostMapping("/")
    public ResponseEntity<OrderMongo> createOrder(@RequestBody OrderMongo orderEntity) {
        OrderMongo savedOrder = orderService.createOrder(orderEntity);
        return ResponseEntity.ok(savedOrder);
    }

    // Actualizar una orden existente.
    @PutMapping("/")
    public ResponseEntity<OrderMongo> updateOrder(@RequestBody OrderMongo OrderMongo) {
        OrderMongo updatedOrder = orderService.updateOrder(OrderMongo);
        return updatedOrder != null ?
                ResponseEntity.ok(updatedOrder) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Actualizar una orden existente, forzando el uso de una ID existente.
    @PutMapping("/{id}")
    public ResponseEntity<OrderMongo> updateOrder(@PathVariable("id") Long orderId, @RequestBody OrderMongo OrderMongo) {
        OrderMongo updatedOrder = orderService.updateOrder(OrderMongo,orderId);
        return updatedOrder != null ?
                ResponseEntity.ok(updatedOrder) :
                ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // Eliminar una orden por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("id") Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }
}
