package com.example.project.services;

import com.example.project.dtos.OrderDTO;
import com.example.project.dtos.OrderItemDTO;
import com.example.project.dtos.UserDTO;
import com.example.project.entities.Order;
import com.example.project.entities.User;
import com.example.project.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;


    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().map(this::convertToUserDTO).collect(Collectors.toList());

    }

    @Transactional
    public UserDTO findById(Long id) {
        User obj = userRepository.findById(id).
                orElseThrow(() -> new RuntimeException("User not found"));
        obj.getOrders().size();

        return convertToUserDTO(obj);
    }


    private UserDTO convertToUserDTO (User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setPassword(user.getPassword());
        userDTO.setPhone(user.getPhone());
        userDTO.setOrderDTOList(convertToOrderDTOList(user));
        return userDTO;
    }

    public List<OrderDTO> convertToOrderDTOList(User user) {
        return user.getOrders().stream().map(x -> {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOrderStatus(x.getOrderStatus().name());
            orderDTO.setId(x.getId());
            orderDTO.setInstant(x.getInstant());
            orderDTO.setItems(convertToOrderItemDTOList(x));
            return orderDTO;
        }).collect(Collectors.toList());
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

