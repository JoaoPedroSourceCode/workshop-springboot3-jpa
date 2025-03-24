package com.example.project.entities.resources;



import com.example.project.entities.Order;
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
    public ResponseEntity<List<Order>> findAll() {
        List <Order> orders = orderServices.findAll();

        return ResponseEntity.ok().body(orders);
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity<Order> findById (@PathVariable long id) {
        Order order = orderServices.findById(id);

        return ResponseEntity.ok().body(order);
    }
}
