package com.example.project.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonPropertyOrder({
        "quantity",
        "price",
        "subTotal",
        "product"
})
public class OrderItemDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer quantity;
    private Double price;
    private Double subTotal;
    private ProductDTO productDTO;

    public OrderItemDTO() {
    }

    public OrderItemDTO(Integer quantity, Double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public ProductDTO getProduct() {
        return productDTO;
    }

    public void setProduct(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

}
