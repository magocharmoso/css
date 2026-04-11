package pt.ul.fc.css.tascaeats.entities.user;

import jakarta.persistence.*;
import pt.ul.fc.css.tascaeats.entities.address.Address;

@Entity
public class Customer extends User {

    @OneToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Address address;

    public Customer(String name, String email) {
        this(name, email, null);
    }

    public Customer(String name, String email, Address address) {
        super(name, email);
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public UserRole getRole() {
        return UserRole.CUSTOMER;
    }
    
}
