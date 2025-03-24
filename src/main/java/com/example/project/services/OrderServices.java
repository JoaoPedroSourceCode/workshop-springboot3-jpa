package com.example.project.services;

import com.example.project.entities.Order;
import com.example.project.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServices {

    @Autowired
    private OrderRepository userRepository;

    public List<Order> findAll () {
        return userRepository.findAll();
    }

    public Order findById (Long id) {
        Optional<Order> obj = userRepository.findById(id);
        return obj.get();
    }
}

