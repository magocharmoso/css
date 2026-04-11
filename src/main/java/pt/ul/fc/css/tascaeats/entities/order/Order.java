package pt.ul.fc.css.tascaeats.entities.order;

import jakarta.persistence.*;
import pt.ul.fc.css.tascaeats.entities.address.Address;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long orderId;

    @Column(nullable = false)
    private String customerVat;

    @OneToMany
    private List<OrderProd> products;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime time;

    @Column(nullable = false)
    private int price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "address_id", referencedColumnName = "id")
    private Address address;

    @Column(nullable = false)
    private OrderStatus status;

    @Column(nullable = false)
    private PaymentMethod method;

    public Order() {}

    public Order(String customerVat, List<OrderProd> products){
        this.customerVat = customerVat;
        this.products = products;
    }

    public Long getOrderId() {return orderId;}

    public String getCustomerVat() {return customerVat;}
    public void setCustomerVat(String customerVat) {this.customerVat = customerVat;}

    public List<OrderProd> getProducts() {return products;}
    public void setProducts(List<OrderProd> products) {this.products = products;}

    public LocalDate getDate() {return date;}
    public void setDate(LocalDate date) {this.date = date;}

    public LocalTime getTime() {return time;}
    public void setTime(LocalTime time) {this.time = time;}

    public int getPrice() {return price;}
    public void setPrice(int price) {this.price = price;}

    public Address getAddress() {return address;}
    public void setAddress(Address address) {this.address = address;}

    public OrderStatus getStatus() {return status;}
    public void setStatus(OrderStatus status) {this.status = status;}

    public PaymentMethod getMethod() {return method;}
    public void setMethod(PaymentMethod method) {this.method = method;}
}
