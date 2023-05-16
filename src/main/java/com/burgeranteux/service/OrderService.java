package com.burgeranteux.service;

import com.burgeranteux.model.Order;
import com.burgeranteux.model.Product;
import com.burgeranteux.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Order getOrder(long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    public void deleteOrder(Order order) {
        orderRepository.deleteById(order.getOrder_id());
    }

}
