package com.example.Lab1TBD.MongoDB.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Lab1TBD.MongoDB.services.UserMongoService;
import com.example.Lab1TBD.MongoDB.models.UserMongo;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserMongoController {

    @Autowired
    private UserMongoService userService;

    // Obtener todos los usuarios
    @GetMapping
    public List<UserMongo> getAllUsers() {
        return userService.getAllUsers();
    }

    // Obtener usuario por ID
    @GetMapping("/{id}")
    public UserMongo getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Guardar un nuevo usuario
    @PostMapping
    public UserMongo saveUser(@RequestBody UserMongo user) {
        return userService.saveUser(user);
    }

    // Buscar usuario por correo electrónico
    @GetMapping("/email/{email}")
    public UserMongo getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    // Eliminar usuario por ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
