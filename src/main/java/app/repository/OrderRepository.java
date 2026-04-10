package app.repository;

import java.util.ArrayList;
import java.util.List;

import app.domain.order.Order;

public class OrderRepository {
    private List<Order> orders;
    public OrderRepository() {
        this.orders = new ArrayList<>();    
    }
    
}
