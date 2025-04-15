package com.example.project.dtos;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

public class OrderDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Instant instant;
    private String orderStatus;
    // Campo para armazenar os items da order
    private List<OrderItemDTO> items;

    public OrderDTO() {
    }

    // Construtor com parâmetros pode ser criado se necessário
    public OrderDTO(Long id, Instant instant, String orderStatus, List<OrderItemDTO> items) {
        this.id = id;
        this.instant = instant;
        this.orderStatus = orderStatus;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO orderDTO = (OrderDTO) o;
        return Objects.equals(id, orderDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
