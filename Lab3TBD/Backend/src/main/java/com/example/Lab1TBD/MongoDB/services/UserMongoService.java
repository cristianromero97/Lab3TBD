package com.example.Lab1TBD.MongoDB.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Lab1TBD.MongoDB.models.UserMongo;
import com.example.Lab1TBD.MongoDB.repositories.UserMongoRepository;
import java.util.List;

@Service
public class UserMongoService {

    @Autowired
    private UserMongoRepository userRepository;

    // Obtener todos los usuarios
    public List<UserMongo> getAllUsers() {
        return userRepository.findAll();
    }

    // Guardar un usuario
    public UserMongo saveUser(UserMongo user) {
        return userRepository.save(user);
    }

    // Buscar usuario por ID
    public UserMongo getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Buscar usuario por correo electrónico
    public UserMongo getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Eliminar usuario
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
