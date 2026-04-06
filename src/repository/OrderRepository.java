package src.repository;

import java.util.ArrayList;
import java.util.List;

import src.domain.order.Order;

public class OrderRepository {
    private List<Order> orders;
    public OrderRepository() {
        this.orders = new ArrayList<>();    
    }
    
}
