package com.example.Lab1TBD.MongoDB.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "order_detailsMongo") // Mapea la colección de MongoDB
public class OrderDetailMongo {
    @Id
    private Long id; // ID único de MongoDB

    private int quantity; // Cantidad del producto en la orden
    private Float price; // Precio unitario del producto
    private String orderId; // ID foráneo que pertenece a la orden (FK)
    private String productId; // ID foráneo que pertenece al producto (FK)
}