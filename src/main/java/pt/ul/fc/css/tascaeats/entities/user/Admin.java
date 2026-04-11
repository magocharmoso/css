package pt.ul.fc.css.tascaeats.entities.user;

import jakarta.persistence.*;
import pt.ul.fc.css.tascaeats.entities.restaurant.Restaurant;

import java.util.*;

@Entity
public class Admin extends User {
	
	@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Restaurant> restaurants;

	public Admin(String name, String email) {
		super(name, email);
		this.restaurants = new ArrayList<>();
	}

	public List<Restaurant> getRestaurants() { return Collections.unmodifiableList(this.restaurants); }

	@Override
	public UserRole getRole() {
		return UserRole.ADMIN;
	}
    
}
