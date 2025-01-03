package com.example.Lab1TBD.MongoDB.services;

import com.example.Lab1TBD.MongoDB.models.ImagesMongo;
import com.example.Lab1TBD.MongoDB.repositories.ImagesMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImagesMongoService {
    @Autowired
    private ImagesMongoRepository imagesMongoRepository;

    public List<ImagesMongo> getAllImages() {
        return imagesMongoRepository.findAll();
    }

    public ImagesMongo getImageById(Long id){
        return imagesMongoRepository.findById(id).orElse(null);
    }

    public ImagesMongo saveImage(ImagesMongo imagesMongo){
        return imagesMongoRepository.save(imagesMongo);
    }
    
    public ImagesMongo updateImage(ImagesMongo imagesMongo){
        if (imagesMongoRepository.existsById(imagesMongo.getId())) {
            return imagesMongoRepository.save(imagesMongo);
        }
        return null;
    }

    public void deleteImage(Long id){
        imagesMongoRepository.deleteById(id);
    }

    // ----------------------------------------------------------------------------------------------------

    public List<ImagesMongo> getByProductId(Long productId) {
        return imagesMongoRepository.findByProductId(productId);
    }
}
