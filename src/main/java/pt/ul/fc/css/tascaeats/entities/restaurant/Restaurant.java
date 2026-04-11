package pt.ul.fc.css.tascaeats.entities.restaurant;

import java.util.*;

import jakarta.persistence.*;

import pt.ul.fc.css.tascaeats.entities.user.Admin;
import pt.ul.fc.css.tascaeats.entities.address.Address;

@Entity
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nif;
    private boolean open;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> menu = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable=false)
    private Admin owner;

    protected Restaurant() { } // JPA

    public Restaurant(String name, Address address, Admin owner) {
        this.name = name;
        this.address = address;
        this.owner = owner;
        this.open = false;
    }

    public Long getNif() { return this.nif; }
    public String getName() { return this.name; }
    public Address getAddress() { return this.address; }
    public Admin getOwner() { return this.owner; }
    public boolean isOpen() { return this.open; }
    public List<Product> getMenu() { return Collections.unmodifiableList(this.menu); } 

    
    public void setName(String name) { this.name = name; } // rebranding
    public void setAddress(Address address) { this.address = address; } // moving
    public void setOwner(Admin owner) { this.owner = owner; } // change owner?
    public void setOpen() { this.open = true; }
    public void setClose() { this.open = false; }
    public void addProduct(Product p) { menu.add(p); }
    public void removeProduct(Product p) { menu.remove(p); }
}
