package app.domain.user;

public class Client extends User {
    private String address;

    public Client(int id, String name, String email) {
        this(id, name, email, "");
    }

    public Client(int id, String name, String email, String address) {
        super(id, name, email);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String getRole() {
        return "CLIENT";
    }
    
}
