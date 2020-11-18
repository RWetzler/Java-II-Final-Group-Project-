package pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pet.beans.Sitter;



public interface SitterRepository extends JpaRepository<Sitter, Long>{

}
