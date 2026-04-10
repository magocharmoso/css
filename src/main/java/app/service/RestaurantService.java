package app.service;

import app.repository.RestaurantRepository;

public class RestaurantService {
    private RestaurantRepository restaurantRepository;
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }
    
    
}
