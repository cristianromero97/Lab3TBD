package com.example.Lab1TBD.MongoDB.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clientsMongo") // Mapea la colección en MongoDB
public class UserMongo {
    @Id
    private Long id; // Identificador único

    private String clientName; // Nombre del cliente
    private String email; // Correo electrónico
    private String password; // Contraseña
    private String phoneNumber; // Número de teléfono
}