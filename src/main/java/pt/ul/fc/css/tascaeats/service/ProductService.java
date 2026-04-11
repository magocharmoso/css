package pt.ul.fc.css.tascaeats.service;

import pt.ul.fc.css.tascaeats.repository.ProductRepository;
import pt.ul.fc.css.tascaeats.repository.RestaurantRepository;

import pt.ul.fc.css.tascaeats.entities.restaurant.Restaurant;
import pt.ul.fc.css.tascaeats.entities.restaurant.Product;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository repo;

    @Autowired
    private final RestaurantRepository restaurantRepo;

    public ProductService(ProductRepository repo, RestaurantRepository restaurantRepo) {
        this.repo = repo;
        this.restaurantRepo = restaurantRepo;
    }

    @Transactional
    public Product createProduct(Long restaurantNif, String name, Long price, String description) {
        Restaurant restaurant = restaurantRepo.findById(restaurantNif)
            .orElseThrow(() -> new IllegalArgumentException("restaurant not found"));
        Product product = new Product(restaurant, name, price, description);
        restaurant.getMenu().add(product); // keep entity state consistent
        return repo.save(product);
    }

    @Transactional
    public void deleteProduct(Long productId) {
        Product product = repo.findById(productId).orElseThrow(() -> new IllegalArgumentException("product not found"));
        Restaurant restaurant = product.getRestaurant();
        if (restaurant != null) {
            restaurant.getMenu().remove(product); // keep in-memory relationship consistent
        }
        repo.delete(product);
    }
}