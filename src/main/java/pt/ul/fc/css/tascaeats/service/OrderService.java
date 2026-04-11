package pt.ul.fc.css.tascaeats.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import pt.ul.fc.css.tascaeats.entities.order.Order;
import pt.ul.fc.css.tascaeats.repository.OrderProdRepository;
import pt.ul.fc.css.tascaeats.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderProdRepository orderProdRepository;

    public Order registerOrder(){
        return new Order();
    }
}
