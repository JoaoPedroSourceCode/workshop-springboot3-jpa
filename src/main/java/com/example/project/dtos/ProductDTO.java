package com.example.project.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@JsonPropertyOrder({
        "id",
        "name",
        "description",
        "price",
        "imgUrL",
        "category",
        "orders"
})
public class ProductDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrL;
    private Set<CategoryDTO> category;


    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String description, Double price, String imgUrL) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrL = imgUrL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrL() {
        return imgUrL;
    }

    public void setImgUrL(String imgUrL) {
        this.imgUrL = imgUrL;
    }

    public Set<CategoryDTO> getCategory() {
        return category;
    }

    public void setCategory(Set<CategoryDTO> category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO orderDTO = (ProductDTO) o;
        return Objects.equals(id, orderDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
