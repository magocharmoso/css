package pt.ul.fc.css.tascaeats.entities.restaurant;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prodId;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable=false)
    private Restaurant restaurant;

    private String name;
    private Long price;

    private String description;
    private boolean availibility;

    protected Product() { } // JPA

    // product available by default
    public Product(Restaurant restaurant, String name, Long price, String description) {
        this(restaurant, name, price, description, true);
    }

    public Product(Restaurant restaurant, String name, Long price, String description, boolean availibility) {
        this.restaurant = restaurant;
        this.name = name;
        this.price = price;
        this.description = description;
        this.availibility = availibility;
    }

    public Long getProdId() { return this.prodId; }
    public Restaurant getRestaurant() { return this.restaurant; }
    public String getName() { return this.name; }
    public Long getPrice() { return this.price; }
    public String getDescription() { return this.description; }
    public boolean isAvailable() { return this.availibility; }

    public void setName(String name) { this.name = name; }
    public void setPrice(Long price) { this.price = price; }
    public void setDescription(String description) { this.description = description; }
    public void makeAvailable() { this.availibility = true; }
    public void makeUnavailable() { this.availibility = false; }

    @Override
    public boolean equals(Object o) {        
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product other = (Product) o;
        return prodId != null && prodId.equals(other.prodId); 
    }
}
