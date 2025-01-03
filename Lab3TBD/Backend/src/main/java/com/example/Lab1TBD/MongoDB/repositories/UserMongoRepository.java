package com.example.Lab1TBD.MongoDB.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.Lab1TBD.MongoDB.models.UserMongo;

@Repository
public interface UserMongoRepository extends MongoRepository<UserMongo, Long> {

    // Buscar usuario por correo electrónico
    UserMongo findByEmail(String email);
}
