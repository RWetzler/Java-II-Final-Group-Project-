package pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pet.beans.Owner;


@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long>{

}
