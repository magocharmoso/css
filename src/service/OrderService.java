package src.service;

import src.repository.OrderRepository;

public class OrderService {
    private OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
}
