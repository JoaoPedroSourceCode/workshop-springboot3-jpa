package com.example.project.entities.resources;


import com.example.project.entities.Category;
import com.example.project.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResources {

    @Autowired
    private CategoryServices categoryServices;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List <Category> categories = categoryServices.findAll();

        return ResponseEntity.ok().body(categories);
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity<Category> findById (@PathVariable long id) {
        Category category = categoryServices.findById(id);

        return ResponseEntity.ok().body(category);
    }
}
