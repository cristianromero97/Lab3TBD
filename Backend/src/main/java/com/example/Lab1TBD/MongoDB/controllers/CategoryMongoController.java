package com.example.Lab1TBD.MongoDB.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Lab1TBD.MongoDB.services.CategoryMongoService;
import com.example.Lab1TBD.MongoDB.models.CategoryMongo;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryMongoController {

    @Autowired
    private CategoryMongoService categoryService;

    // Obtener todas las categorías
    @GetMapping("/")
    public ResponseEntity<List<CategoryMongo>> getAllCategories() {
        List<CategoryMongo> found = categoryService.getAllCategories();
        return found.isEmpty() ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.ok(found);
    }

    // Obtener categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<CategoryMongo> getCategoryById(@PathVariable Long id) {
        CategoryMongo found = categoryService.getCategoryById(id);
        return found == null?
                ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.ok(found);
    }

    // Buscar categoría por nombre
    @GetMapping("/name/{name}")
    public ResponseEntity<CategoryMongo> getCategoryByName(@PathVariable String name) {
        CategoryMongo found = categoryService.getCategoryByName(name);
        return found == null?
                ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.ok(found);
    }

    // Guardar una nueva categoría. Debe tener una ID no existente.
    @PostMapping("/")
    public ResponseEntity<CategoryMongo> saveCategory(@RequestBody CategoryMongo category) {
        CategoryMongo saved = categoryService.saveCategory(category);
        return saved == null?
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build() :
                ResponseEntity.ok(saved);
    }

    // Actualizar una categoria existente. Debe tener una ID existente.
    @PutMapping("/")
    public ResponseEntity<CategoryMongo> updateCategory(@RequestBody CategoryMongo category) {
        CategoryMongo updated = categoryService.updateCategory(category);
        return updated == null?
                ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.ok(updated);
    }

    // Eliminar categoría por ID
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
