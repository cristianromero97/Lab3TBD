package com.example.Lab1TBD.MongoDB.controllers;

import com.example.Lab1TBD.MongoDB.models.ImagesMongo;
import com.example.Lab1TBD.MongoDB.services.ImagesMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImagesMongoController {
    @Autowired
    private ImagesMongoService imagesMongoService;

    @GetMapping("/")
    public ResponseEntity<List<ImagesMongo>> getAllImages() {
        List<ImagesMongo> imagesMongo = imagesMongoService.getAllImages();
        return (imagesMongo.isEmpty())?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.ok(imagesMongo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImagesMongo> getImageById(@PathVariable("id") Long id) {
        ImagesMongo imagesMongo = imagesMongoService.getImageById(id);
        return (imagesMongo == null)?
                ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.ok(imagesMongo);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ImagesMongo>> getImagesByProductId(@PathVariable("productId") Long productId) {
        List<ImagesMongo> imagesMongo = imagesMongoService.getByProductId(productId);
        return (imagesMongo.isEmpty())?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.ok(imagesMongo);
    }

    @PostMapping("/")
    public ResponseEntity<ImagesMongo> saveImage(@RequestBody ImagesMongo imagesMongo) {
        ImagesMongo savedImage = imagesMongoService.saveImage(imagesMongo);
        return savedImage == null?
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build() :
                ResponseEntity.ok(savedImage);
    }

    @PutMapping("/")
    public ResponseEntity<ImagesMongo> updateImage(@RequestBody ImagesMongo imagesMongo) {
        ImagesMongo updatedImage = imagesMongoService.updateImage(imagesMongo);
        return updatedImage == null?
                ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build() :
                ResponseEntity.ok(updatedImage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable("id") Long id){
        imagesMongoService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }
}
