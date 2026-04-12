package pt.ul.fc.css.tascaeats.service;

import pt.ul.fc.css.tascaeats.entities.user.Admin;
import pt.ul.fc.css.tascaeats.entities.user.Courier;
import pt.ul.fc.css.tascaeats.entities.user.Customer;
import pt.ul.fc.css.tascaeats.entities.user.User;
import pt.ul.fc.css.tascaeats.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(String name, String email, String role) {
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email already in use");
        }

        User user = createUserByRole(name, email, role);

        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public boolean verifyUserExists(String email) {
        return userRepository.existsByEmail(email);
    }
    
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }
    
    public User updateUser(Long id, String name, String email, String role) {
        User existingUser = getUserById(id);

        boolean emailChanged = !existingUser.getEmail().equalsIgnoreCase(email);
        if (emailChanged && userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email already in use");
        }

        User updatedUser = createUserByRole(name, email, role);
        updatedUser.setId(id);
        return userRepository.save(updatedUser);
    }

    public void removeUser(Long id) {
        if (!userRepository.deleteById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    private User createUserByRole(String name, String email, String role) {
        String normalizedRole = role == null ? "" : role.trim().toUpperCase();

        switch (normalizedRole) {
            case "CUSTOMER":
            case "CLIENT":
                return new Customer(name, email);
            case "COURIER":
                return new Courier(name, email);
            case "ENTREGADOR":
                return new Courier(name, email);
            case "ADMIN":
                return new Admin(name, email);
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }
    }
}