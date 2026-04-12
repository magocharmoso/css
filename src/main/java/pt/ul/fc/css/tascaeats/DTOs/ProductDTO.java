package pt.ul.fc.css.tascaeats.DTOs;

import pt.ul.fc.css.tascaeats.entities.restaurant.Product;
import pt.ul.fc.css.tascaeats.entities.restaurant.Restaurant;

public class ProductDTO {
    private final Long prodId;
    private final Long restaurantId;
    private final String name;
    private final Long price;
    private final String description;
    private final boolean availibility;

    public ProductDTO(Long prodId, Long restaurantId, String name, Long price, String description, boolean availibility) {
        this.prodId = prodId;
        this.restaurantId = restaurantId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.availibility = availibility;
    }

    public Long getProdId() { return this.prodId; }
    public Long getRestaurantId() { return this.restaurantId; }
    public String getName() { return this.name; }
    public Long getPrice() { return this.price; }
    public String getDescription() { return this.description; }
    public boolean getAvailibility() { return this.availibility; }

    // Convert entity -> DTO
    public static ProductDTO fromEntity(Product p) {
        Long restaurantNif = p.getRestaurant().getNif();
        return new ProductDTO(p.getProdId(), restaurantNif, p.getName(), p.getPrice(), p.getDescription(), p.isAvailable());
    }

}
