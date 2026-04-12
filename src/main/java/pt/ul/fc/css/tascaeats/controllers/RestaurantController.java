package pt.ul.fc.css.tascaeats.controllers.restaurant;

import java.util.*;
import jakarta.persistence.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import pt.ul.fc.css.tascaeats.entities.restaurant.Restaurant;
import pt.ul.fc.css.tascaeats.service.RestaurantService;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
    private final RestaurantService svc;

    public RestaurantController(RestaurantService svc) { this.svc = svc; }

    // get all restaurants
    @GetMapping
    public List<Restaurant> list() {
        return svc.findAll();
    }

    // D: get restaurants by name
    @GetMapping(params = "name")
    public List<Restaurant> listByName(@RequestParam String name) {
        return svc.findByName(name);
    }

    // D: get restaurants by city
    @GetMapping(params = "city")
    public List<Restaurant> listByCity(@RequestParam String city) {
        return svc.findByCity(city);
    }

    // E: create restaurant
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurant create(@RequestBody @Valid Restaurant restaurant) { 
        return svc.createRestaurant(restaurant); 
    }

    // E: manage restaurant's state (open, closed)
    @PatchMapping("/{id}")
    public Restaurant patchState(@PathVariable Long id, @RequestParam("open") boolean state) {
        return svc.setOpenState(id, state);
    }
}