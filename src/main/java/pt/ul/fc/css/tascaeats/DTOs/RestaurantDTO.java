package pt.ul.fc.css.tascaeats.DTOs;

import java.util.*;

import pt.ul.fc.css.tascaeats.entities.address.Address;
import pt.ul.fc.css.tascaeats.entities.restaurant.Product;
import pt.ul.fc.css.tascaeats.entities.restaurant.Restaurant;
import pt.ul.fc.css.tascaeats.entities.user.Admin;

public final class RestaurantDTO {
    private final Long nif;
    private final String name;
    private final boolean open;
    private final AddressDTO address;
    private final Long ownerId;
    private final List<ProductDTO> menuProducts;

    public RestaurantDTO(Long nif, String name, boolean open, AddressDTO address, Long ownerId, List<ProductDTO> menuProducts) {
        this.nif = nif;
        this.name = name;
        this.open = open;
        this.address = address;
        this.ownerId = ownerId;
        this.menuProducts = menuProducts;
    }

    public Long getNif() { return this.nif; }
    public String getName() { return this.name; }
    public boolean isOpen() { return this.open; }
    public AddressDTO getAddress() { return this.address; }
    public Long getOwnerId() { return this.ownerId; }
    public List<ProductDTO> getMenuProducts() { return this.menuProducts; }

    // Convert entity -> DTO
    public static RestaurantDTO fromEntity(Restaurant r) {
        List<ProductDTO> menu = new ArrayList<>();
        for (Product p : r.getMenu()) {
            menu.add(ProductDTO.fromEntity(p));
        }
        AddressDTO address = AddressDTO.fromEntity(r.getAddress());
        Long ownerId = r.getOwner() != null ? r.getOwner().getId() : null;
        return new RestaurantDTO(r.getNif(), r.getName(), r.isOpen(), address, ownerId, menu);
    }
}
