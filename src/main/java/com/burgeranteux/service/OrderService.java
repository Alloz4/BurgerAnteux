package com.burgeranteux.service;

import com.burgeranteux.model.Order;
import com.burgeranteux.model.User;
import com.burgeranteux.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Order order) {
        orderRepository.deleteById(order.getOrder_id());
    }

    public List<Order> getOrderByUser(long user_id) {
        return orderRepository.findByUserId(user_id);
    }


    @Transactional
    public Order updateOrder(Order order) {
        Order existingOrder = orderRepository.findById(order.getOrder_id()).orElse(null);
        if (existingOrder != null) {
            existingOrder.setState(order.getState());
        }
        assert existingOrder != null;
        return orderRepository.save(existingOrder);
    }

}
