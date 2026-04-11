package pt.ul.fc.css.tascaeats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.ul.fc.css.tascaeats.entities.restaurant.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
}
