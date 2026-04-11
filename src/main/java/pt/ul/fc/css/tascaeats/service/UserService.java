package pt.ul.fc.css.tascaeats.service;

import pt.ul.fc.css.tascaeats.entities.user.Admin;
import pt.ul.fc.css.tascaeats.entities.user.Courier;
import pt.ul.fc.css.tascaeats.entities.user.Customer;
import pt.ul.fc.css.tascaeats.entities.user.User;
import pt.ul.fc.css.tascaeats.repository.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User register(String name, String email, String role) {
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email already in use");
        }

        int id = (int) userRepository.count() + 1;
        User user = createUserByRole(id, name, email, role);

        return userRepository.save(user);
    }

    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
    public boolean verifyUserExists(String email) {
        return userRepository.existsByEmail(email);
    }
    
    public User updateUser(int id, String name, String email, String role) {
        User existingUser = getUserById(id);

        boolean emailChanged = !existingUser.getEmail().equalsIgnoreCase(email);
        if (emailChanged && userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email already in use");
        }

        User updatedUser = createUserByRole(id, name, email, role);
        return userRepository.save(updatedUser);
    }

    public void removeUser(int id) {
        if (!userRepository.deleteById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
    }

    private User createUserByRole(int id, String name, String email, String role) {
        String normalizedRole = role == null ? "" : role.trim().toUpperCase();

        switch (normalizedRole) {
            case "CLIENT":
                return new Customer(name, email);
            case "COURIER":
                return new Courier(name, email);
            case "ADMIN":
                return new Admin(name, email);
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }
    }
}