package pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pet.beans.Sitter;


@Repository
public interface SitterRepository extends JpaRepository<Sitter, Long>{

}
