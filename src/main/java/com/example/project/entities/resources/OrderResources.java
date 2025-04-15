package com.example.project.entities.resources;

import com.example.project.dtos.OrderDTO;
import com.example.project.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResources {

    @Autowired
    private OrderServices orderServices;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> findAll() {
        List<OrderDTO> ordersDTO = orderServices.findAll();
        return ResponseEntity.ok().body(ordersDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable Long id) {
        OrderDTO orderDTO = orderServices.getOrderDTO(id);
        return ResponseEntity.ok().body(orderDTO);
    }
}