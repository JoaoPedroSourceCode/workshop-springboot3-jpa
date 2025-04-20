package com.example.project.entities.resources;


import com.example.project.dtos.ProductDTO;
import com.example.project.entities.Product;
import com.example.project.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResources {

    @Autowired
    private ProductServices productServices;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll() {
        List <ProductDTO> productsDTO = productServices.findAll();

        return ResponseEntity.ok().body(productsDTO);
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity<ProductDTO> findById (@PathVariable long id) {
        ProductDTO productsDTO = productServices.findById(id);

        return ResponseEntity.ok().body(productsDTO);
    }
    
    
}
