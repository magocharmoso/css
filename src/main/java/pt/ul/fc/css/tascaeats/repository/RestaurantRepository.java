package pt.ul.fc.css.tascaeats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;
import pt.ul.fc.css.tascaeats.entities.restaurant.Restaurant;
import pt.ul.fc.css.tascaeats.entities.address.Address;

import java.util.*;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Long>{
    @Query("SELECT a FROM Restaurant a WHERE a.name LIKE %:q%")
    List<Restaurant> findByName(@Param("q") String q);

    @Query("SELECT r FROM Restaurant r WHERE LOWER(r.address.local) LIKE CONCAT('%', LOWER(:q), '%')")
    List<Restaurant> findByCity(@Param("q") String q);
}
