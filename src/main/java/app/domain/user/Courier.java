package app.domain.user;

public class Courier extends User {
	private String vehicle;

	public Courier(int id, String name, String email) {
		this(id, name, email, "");
	}

	public Courier(int id, String name, String email, String vehicle) {
		super(id, name, email);
		this.vehicle = vehicle;
	}

	public String getVehicle() {
		return vehicle;
	}

	@Override
	public String getRole() {
		return "COURIER";
	}
    
}
