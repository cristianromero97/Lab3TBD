package com.example.Lab1TBD.MongoDB.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "productsMongo")
public class ProductMongo {
    @Id
    private Long id;

    private String productName;
    private String description;
    private int price;
    private int stock;
    private String productStatus;
    private int categoryId; // MongoDB usa referencias simples (puedes mapear esto a una entidad Category manualmente si es necesario)
}

