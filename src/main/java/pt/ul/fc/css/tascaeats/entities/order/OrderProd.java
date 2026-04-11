package pt.ul.fc.css.tascaeats.entities.order;

import jakarta.persistence.*;
import pt.ul.fc.css.tascaeats.entities.restaurant.Product;

@Entity
public class OrderProd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderProdId;

    @ManyToOne
    private Product prod;

    @Column(nullable = false)
    private int qty;

    public OrderProd() {}

    public OrderProd(int qty, Product prod) {
        this.qty = qty;
        this.prod = prod;
    }

    public Long getOrderProdId() {return orderProdId;}

    public Product getProd() {return prod;}
    public void setProd(Product prod) {this.prod = prod;}

    public int getQty() {return qty;}
    public void setQty(int qty) {this.qty = qty;}
}
