package pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pet.beans.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
