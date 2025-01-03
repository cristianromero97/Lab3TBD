package com.example.Lab1TBD.MongoDB.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "imagesMongo")
public class ImagesMongo {
    @Id
    private Long id;
    private String imageUrl; //URL de donde se va a hostear la imagen.
    private Long productId;  //(FK) El producto asociado a la imagen.
}
