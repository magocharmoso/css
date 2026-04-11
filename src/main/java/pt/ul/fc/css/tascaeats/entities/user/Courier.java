package pt.ul.fc.css.tascaeats.entities.user;

import jakarta.persistence.*;

@Entity
public class Courier extends User {
	private String vehicle;

	public Courier(String name, String email) {
		this(name, email, "");
	}

	public Courier(String name, String email, String vehicle) {
		super(name, email);
		this.vehicle = vehicle;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public UserRole getRole() {
		return UserRole.COURIER;
	}
    
}
