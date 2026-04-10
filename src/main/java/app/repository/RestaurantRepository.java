package app.repository;

import java.util.ArrayList;
import java.util.List;

import app.domain.restaurant.Restaurant;

public class RestaurantRepository {
    private List<Restaurant> restaurants;
    public RestaurantRepository() {
        this.restaurants = new ArrayList<>();
    }
}
