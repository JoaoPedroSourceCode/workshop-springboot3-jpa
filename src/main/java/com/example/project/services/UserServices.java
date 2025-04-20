package com.example.project.services;

import com.example.project.dtos.*;
import com.example.project.entities.Order;
import com.example.project.entities.Product;
import com.example.project.entities.User;
import com.example.project.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
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
        return userDTO;
    }

    public List<OrderDTO> convertToOrderDTOList(User user) {
        return user.getOrders().stream().map(x -> {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOrderStatus(x.getOrderStatus().name());
            orderDTO.setId(x.getId());
            orderDTO.setInstant(x.getInstant());
            orderDTO.setItems(convertToOrderItemDTOSet(x));
            return orderDTO;
        }).collect(Collectors.toList());
    }

    private Set<OrderItemDTO> convertToOrderItemDTOSet(Order order) {
        return order.getItems().stream().map(item -> {
            OrderItemDTO itemDTO = new OrderItemDTO();
            itemDTO.setOrderId(order.getId());
            itemDTO.setProductId(item.getProduct().getId());
            itemDTO.setQuantity(item.getQuantity());
            itemDTO.setPrice(item.getPrice());


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

    private Set<CategoryDTO> convertToCategoryDTOSet(Product product) {
        return product.getCategories().stream().map(cat -> {
            CategoryDTO cDto = new CategoryDTO();
            cDto.setId(cat.getId());
            cDto.setName(cat.getName());
            return cDto;
        }).collect(Collectors.toSet());
    }
}

