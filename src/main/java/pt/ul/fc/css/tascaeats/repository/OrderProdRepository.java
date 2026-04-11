package pt.ul.fc.css.tascaeats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.ul.fc.css.tascaeats.entities.order.OrderProd;

@Repository
public interface OrderProdRepository extends JpaRepository<OrderProd,Long>{
}
