package pt.ul.fc.css.tascaeats.service;

import java.util.*;
import jakarta.persistence.*;

import pt.ul.fc.css.tascaeats.repository.RestaurantRepository;

import pt.ul.fc.css.tascaeats.entities.restaurant.Restaurant;
import pt.ul.fc.css.tascaeats.entities.restaurant.Product;

import pt.ul.fc.css.tascaeats.DTOs.ProductDTO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RestaurantService {
    @Autowired
    private final RestaurantRepository repo;

    public RestaurantService(RestaurantRepository repo) {
        this.repo = repo;
    }

    // get all restaurants
    public List<Restaurant> findAll() {
        return this.repo.findAll();
    }

    // D: get restaurants by name
    public List<Restaurant> findByName(String name) {
        return this.repo.findByName(name);
    }

    // D: get restaurants by city
    public List<Restaurant> findByCity(String city) {
        return this.repo.findByCity(city);
    }

    // E: create restaurant
    @Transactional
    public Restaurant createRestaurant(Restaurant restaurant) {
        return this.repo.save(restaurant);
    }

    // E: manage restaurant's state (open, closed)
    @Transactional
    public Restaurant setOpenState(Long id, boolean state) {
        Restaurant restaurant = this.repo.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Restaurant not found: " + id));
        if (state) { restaurant.setOpen(); } else { restaurant.setClose(); }
        return this.repo.save(restaurant);
    }

    // G: get menu of given restaurant
    public List<Product> findMenu(Long restaurantId) {
        Restaurant restaurant = this.repo.findById(restaurantId)
            .orElseThrow(() -> new EntityNotFoundException("Restaurant not found: " + restaurantId));
        return restaurant.getMenu();
    }

    // F: add product to menu
    @Transactional
    public Product createProduct(Long restaurantId, Product product) {
        Restaurant restaurant = this.repo.findById(restaurantId)
            .orElseThrow(() -> new EntityNotFoundException("Restaurant not found: " + restaurantId));
        restaurant.addProduct(product);
        this.repo.save(restaurant);
        return product;
    }

    // F: delete product from menu
    @Transactional
    public void deleteProduct(Long restaurantId, Long productId) {
        Restaurant restaurant = this.repo.findById(restaurantId)
            .orElseThrow(() -> new EntityNotFoundException("Restaurant not found: " + restaurantId));
        restaurant.removeProduct(productId);
        this.repo.save(restaurant);
    }

    // F: update product from menu
    @Transactional
    public Product updateProduct(Long restaurantId, Long productId, ProductDTO dto) {
        Restaurant restaurant = repo.findById(restaurantId)
            .orElseThrow(() -> new EntityNotFoundException("Restaurant not found: " + restaurantId));
        Product product = restaurant.getMenu().stream()
            .filter(p -> Objects.equals(p.getProdId(), productId))
            .findFirst()
            .orElseThrow(() -> new EntityNotFoundException("Product not found: " + productId));
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        if(dto.getAvailibility()) { product.makeAvailable(); } else { product.makeUnavailable(); }

        repo.save(restaurant);
        return product;
    }
}