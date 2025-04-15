package com.example.project.services;

import com.example.project.dtos.OrderDTO;
import com.example.project.dtos.OrderItemDTO;
import com.example.project.entities.Order;
import com.example.project.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServices {
    @Autowired
    private OrderRepository orderRepository;


    @Transactional
    public List<OrderDTO> findAll() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(this::convertToOrderDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public OrderDTO getOrderDTO(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        // Força a inicialização da coleção de itens para evitar problemas de lazy loading
        order.getItems().size();
        return convertToOrderDTO(order);
    }

    private OrderDTO convertToOrderDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setInstant(order.getInstant());
        dto.setOrderStatus(order.getOrderStatus().name());
        dto.setItems(convertToOrderItemDTOList(order));
        return dto;
    }

    private List<OrderItemDTO> convertToOrderItemDTOList(Order order) {
        return order.getItems().stream().map(item -> {
            OrderItemDTO itemDTO = new OrderItemDTO();
            // Obtém o id da order a partir do objeto 'order' (todos os itens pertencem a essa order)
            itemDTO.setOrderId(order.getId());
            // Obtém o id do product a partir do item
            itemDTO.setProductId(item.getProduct().getId());
            itemDTO.setQuantity(item.getQuantity());
            itemDTO.setPrice(item.getPrice());
            return itemDTO;
        }).collect(Collectors.toList());
    }
}