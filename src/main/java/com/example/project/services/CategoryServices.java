package com.example.project.services;

import com.example.project.entities.Category;
import com.example.project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryServices {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll () {
        return categoryRepository.findAll();
    }

    public Category findById (Long id) {
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.get();
    }
}

