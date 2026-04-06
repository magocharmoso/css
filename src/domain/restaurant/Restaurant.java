package src.domain.restaurant;

import java.util.List;

import src.domain.user.Admin;

import java.util.ArrayList;

public class Restaurant {
    private boolean isOpen;
    private String name;
    private String city;
    private List<Product> menu;
    private Admin Owner;

    public Restaurant(String name, String city, Admin owner) {
        this.name = name;
        this.city = city;
        this.Owner = owner;
        this.menu = new ArrayList<>();
        this.isOpen = false;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    void open() {
        isOpen = true;
    }
    void close() {
        isOpen = false;
    }
    boolean isOpen() {
        return isOpen;
    }

    void addProduct(String name, double price) {
        if(menu.contains(new Product(name, price))) {
            throw new IllegalArgumentException("Product already exists in the menu");
        }
        menu.add(new Product(name, price));
    }

    void removeProduct(String name) {
        if (!menu.removeIf(product -> product.getName().equals(name))) {
            throw new IllegalArgumentException("Product not found in the menu");
        }
    }

    void updateProductPrice(String name, double newPrice) {
        for (Product product : menu) {
            if (product.getName().equals(name)) {
                product.price = newPrice;
                return;
            }
        }
        throw new IllegalArgumentException("Product not found in the menu");
    }

    

    
}
