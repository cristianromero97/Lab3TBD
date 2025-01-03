package com.example.Lab1TBD.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Lab1TBD.persistence.entities.CustomerOpinion;
import com.example.Lab1TBD.services.CustomerOpinionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer-opinions")
@CrossOrigin("*")
public class CustomerOpinionController {

    @Autowired
    private CustomerOpinionService customerOpinionService;

    // Buscar una opinión por ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomerOpinion> getCustomerOpinionById(@PathVariable Long id) {
        CustomerOpinion opinion = customerOpinionService.findCustomerOpinionId(id);
        if (opinion != null) {
            return ResponseEntity.ok(opinion);
        }
        return ResponseEntity.notFound().build();
    }

    // Buscar opiniones por ID de cliente
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<CustomerOpinion>> getOpinionsByCustomerId(@PathVariable Long customerId) {
        List<CustomerOpinion> opinions = customerOpinionService.findCustomerOpinionByCustomerId(customerId);
        if (opinions != null && !opinions.isEmpty()) {
            return ResponseEntity.ok(opinions);
        }
        return ResponseEntity.noContent().build();
    }

    // Buscar opiniones por ID de producto
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<CustomerOpinion>> getOpinionsByProductId(@PathVariable Long productId) {
        List<CustomerOpinion> opinions = customerOpinionService.findCustomerOpinionByProductId(productId);
        if (opinions != null && !opinions.isEmpty()) {
            return ResponseEntity.ok(opinions);
        }
        return ResponseEntity.noContent().build();
    }

    // Guardar una nueva opinión
    @PostMapping
    public ResponseEntity<String> createCustomerOpinion(@RequestBody CustomerOpinion customerOpinion) {
        customerOpinionService.keepCustomerOpinion(customerOpinion);
        return ResponseEntity.ok("Customer opinion saved successfully.");
    }

    // Editar una opinión existente
    @PutMapping
    public ResponseEntity<String> updateCustomerOpinion(@RequestBody CustomerOpinion customerOpinion) {
        customerOpinionService.editCustomerOpinion(customerOpinion);
        return ResponseEntity.ok("Customer opinion updated successfully.");
    }

    // Borrar una opinión por ID
    @DeleteMapping("/{opinionId}")
    public ResponseEntity<String> deleteCustomerOpinion(@PathVariable Long opinionId) {
        customerOpinionService.eraseCustomerOpinion(opinionId);
        return ResponseEntity.ok("Customer opinion deleted successfully.");
    }
}