package com.example.project.services;

import com.example.project.dtos.CategoryDTO;
import com.example.project.dtos.OrderDTO;
import com.example.project.dtos.OrderItemDTO;
import com.example.project.dtos.ProductDTO;
import com.example.project.dtos.UserDTO;
import com.example.project.entities.Order;
import com.example.project.entities.Product;
import com.example.project.entities.User;
import com.example.project.repositories.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServices {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional
    public List<OrderDTO> findAll() {
        return orderRepository.findAll().stream()
                .map(this::convertToOrderDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public OrderDTO getOrderDTO(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return convertToOrderDTO(order);
    }

    private OrderDTO convertToOrderDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setInstant(order.getInstant());
        dto.setOrderStatus(order.getOrderStatus().name());
        dto.setUserDTO(convertToUserDTO(order.getClient()));
        dto.setItems(convertToOrderItemDTOSet(order));
        dto.setTotal(order.getTotal());
        return dto;
    }

    private Set<OrderItemDTO> convertToOrderItemDTOSet(Order order) {
        return order.getItems().stream().map(item -> {
            OrderItemDTO itemDTO = new OrderItemDTO();
            itemDTO.setQuantity(item.getQuantity());
            itemDTO.setPrice(item.getPrice());
            itemDTO.setSubTotal(item.getSubTotal());

            Product product = item.getProduct();
            ProductDTO pDto = new ProductDTO();
            pDto.setId(product.getId());
            pDto.setName(product.getName());
            pDto.setDescription(product.getDescription());
            pDto.setPrice(product.getPrice());
            pDto.setImgUrL(product.getImgUrL());
            pDto.setCategory(convertToCategoryDTOSet(product));

            itemDTO.setProduct(pDto);
            return itemDTO;
        }).collect(Collectors.toSet());
    }

    private UserDTO convertToUserDTO(User user) {
        UserDTO uDto = new UserDTO();
        uDto.setId(user.getId());
        uDto.setName(user.getName());
        uDto.setEmail(user.getEmail());
        uDto.setPhone(user.getPhone());
        uDto.setPassword(user.getPassword());
        return uDto;
    }

    private Set<CategoryDTO> convertToCategoryDTOSet(Product product) {
        return product.getCategories().stream().map(cat -> {
            CategoryDTO cDto = new CategoryDTO();
            cDto.setId(cat.getId());
            cDto.setName(cat.getName());
            return cDto;
        }).collect(Collectors.toSet());
    }
}
