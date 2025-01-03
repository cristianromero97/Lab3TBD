package com.example.Lab1TBD.MongoDB.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Lab1TBD.MongoDB.repositories.CategoryMongoRepository;
import com.example.Lab1TBD.MongoDB.models.CategoryMongo;
import java.util.List;

@Service
public class CategoryMongoService {
    @Autowired
    private CategoryMongoRepository categoryRepository;

    // Obtener todas las categorías
    public List<CategoryMongo> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Buscar categoría por ID
    public CategoryMongo getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    // Guardar una categoría. Debe tener una ID no existente/nula.
    public CategoryMongo saveCategory(CategoryMongo category) {
        if (category.getId() == null || categoryRepository.existsById(category.getId())){
            return null;
        }
        return categoryRepository.save(category);
    }

    // Actualizar una categoria. Debe tener una ID existente.
    public CategoryMongo updateCategory(CategoryMongo category) {
        if (category.getId() != null && categoryRepository.existsById(category.getId())){
            return categoryRepository.save(category);
        }
        return null;
    }

    // Eliminar categoría
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    // Buscar categoría por nombre
    public CategoryMongo getCategoryByName(String name) {
        return categoryRepository.findByName(name).orElse(null);
    }
}
