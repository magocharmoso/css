package src.domain.order;

import src.domain.restaurant.Restaurant;
import src.domain.user.Client;
import src.domain.user.Courier;

public class Order {
    private int id;
    private Client client;
    private Courier courier;
    private OrderStatus status;
    private Restaurant restaurant;
    private Product[] products;

    public Order(int id, Client client) {
        this.id = id;
        this.client = client;
        this.status = OrderStatus.PENDING;
    }

    void atributeCourier(Courier courier) {
        this.courier = courier;
    }

    void updateStatus(OrderStatus newStatus) {
        this.status = newStatus;
    }
    
}
