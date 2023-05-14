package com.burgeranteux.service;

import com.burgeranteux.model.Order;
import com.burgeranteux.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public void deleteOrder(Order order) {
        orderRepository.deleteById(order.getId_order());
    }

}
