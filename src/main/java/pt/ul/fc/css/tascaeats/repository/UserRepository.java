package pt.ul.fc.css.tascaeats.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import pt.ul.fc.css.tascaeats.entities.user.User;


@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();
    private long nextId = 1L;

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(nextId++);
        }

        for (int i = 0; i < users.size(); i++) {
            if (Objects.equals(users.get(i).getId(), user.getId())) {
                users.set(i, user);
                return user;
            }
        }

        users.add(user);
        return user;
    }

    public Optional<User> findById(Long id) {
        return users.stream()
                .filter(user -> Objects.equals(user.getId(), id))
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

    public boolean deleteById(Long id) {
        return users.removeIf(user -> Objects.equals(user.getId(), id));
    }

    public boolean existsById(Long id) {
        return users.stream().anyMatch(user -> Objects.equals(user.getId(), id));
    }

    public long count() {
        return users.size();
    }
}
