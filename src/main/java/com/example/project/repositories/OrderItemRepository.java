package com.example.project.repositories;

import com.example.project.entities.OrderItem;
import com.example.project.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK>{
        }
