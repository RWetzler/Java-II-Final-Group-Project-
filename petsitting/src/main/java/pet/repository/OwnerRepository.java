package pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.beans.Owner;



public interface OwnerRepository extends JpaRepository<Owner, Long>{

}
