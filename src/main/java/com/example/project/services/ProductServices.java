package com.example.project.services;

import com.example.project.dtos.CategoryDTO;
import com.example.project.dtos.ProductDTO;
import com.example.project.entities.Product;
import com.example.project.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class ProductServices {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::convertToProductDTO).collect(Collectors.toList());
    }

    @Transactional
    public ProductDTO findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return convertToProductDTO(product);
    }

    private ProductDTO convertToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setDescription(product.getDescription());
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setImgUrL(product.getImgUrL());
        productDTO.setCategory(convertToCategoryDTOSet(product));
        return productDTO;
    }

    private Set<CategoryDTO> convertToCategoryDTOSet(Product product) {
        return product.getCategories().stream().map(category -> {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setId(category.getId());
            categoryDTO.setName(category.getName());

            return categoryDTO;
        }).collect(Collectors.toSet());
    }
}



