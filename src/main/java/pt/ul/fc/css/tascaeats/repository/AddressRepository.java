package pt.ul.fc.css.tascaeats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pt.ul.fc.css.tascaeats.entities.address.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long>{

}
