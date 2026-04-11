package pt.ul.fc.css.tascaeats.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import pt.ul.fc.css.tascaeats.entities.user.User;



public class UserRepository {
    private final List<User> users = new ArrayList<>();

    public User save(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == user.getId()) {
                users.set(i, user);
                return user;
            }
        }

        users.add(user);
        return user;
    }

    public Optional<User> findById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    public Optional<User> findByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    public boolean existsByEmail(String email) {
        return users.stream().anyMatch(user -> user.getEmail().equalsIgnoreCase(email));
    }

    public List<User> findAll() {
        return Collections.unmodifiableList(users);
    }

    public boolean deleteById(int id) {
        return users.removeIf(user -> user.getId() == id);
    }

    public boolean existsById(int id) {
        return users.stream().anyMatch(user -> user.getId() == id);
    }

    public long count() {
        return users.size();
    }
}
