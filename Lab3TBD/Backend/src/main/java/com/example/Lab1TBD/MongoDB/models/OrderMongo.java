package com.example.Lab1TBD.MongoDB.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Timestamp;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ordersMongo")  // Nombre de la colección en MongoDB
public class OrderMongo {
    @Id
    private Long id;  // ID ÚNICO

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp date; // Fecha en que se realizó la orden
    private String status;  // Estado de la orden (pendiente, pagada, enviada)
    private Float total;    // Total a pagar de la orden (OJO, todos los productos del cliente)
    private Long clientId; // Identificador foráneo del cliente (FK)
}
