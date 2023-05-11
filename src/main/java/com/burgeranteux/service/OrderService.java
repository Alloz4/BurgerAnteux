package com.burgeranteux.service;

import com.burgeranteux.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    OrderRepository orderRepository;

    public OrderService (OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
}
