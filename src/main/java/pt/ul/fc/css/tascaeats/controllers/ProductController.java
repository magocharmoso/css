package pt.ul.fc.css.tascaeats.controllers.restaurant;

import java.util.*;
import jakarta.persistence.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import pt.ul.fc.css.tascaeats.entities.restaurant.Product;
import pt.ul.fc.css.tascaeats.entities.restaurant.Restaurant;
import pt.ul.fc.css.tascaeats.service.RestaurantService;

import pt.ul.fc.css.tascaeats.DTOs.ProductDTO;

@RestController
@RequestMapping("/api/restaurants/{id}/menu")
public class ProductController {
    private final RestaurantService svc;

    public ProductController(RestaurantService svc) { this.svc = svc; }

    // G: get menu of given restaurant
    @GetMapping
    public List<Product> list(@PathVariable("id") Long restaurantId) {
        return svc.findMenu(restaurantId);
    }
    
    // F: add product to menu
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@PathVariable("id") Long restaurantId, @RequestBody @Valid Product product) {
        return svc.createProduct(restaurantId, product);
    }

    // F: delete product from menu
    @DeleteMapping("/{prodId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long restaurantId, @PathVariable Long prodId) {
        svc.deleteProduct(restaurantId, prodId);
    }

    // F: update product from menu
    @PutMapping("/{prodId}")
    public Product update(@PathVariable("id") Long restaurantId, @PathVariable Long prodId, Product product) {
        ProductDTO dto = ProductDTO.fromEntity(product);
        return svc.updateProduct(restaurantId, prodId, dto);
    }

}