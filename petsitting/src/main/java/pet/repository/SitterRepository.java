package pet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pet.beans.Sitter;


@Repository
public interface SitterRepository extends JpaRepository<Sitter, Long>{

			
			@Query("SELECT s FROM Sitter s ORDER BY s.certifications ASC")
		    public List<Sitter> findByOrderByCertifications();
			
			@Query("SELECT s FROM Sitter s ORDER BY s.maxPets ASC")
		    public List<Sitter> findByOrderByMaxPets();
			
			@Query("SELECT s FROM Sitter s ORDER BY s.averageRating DESC")
		    public List<Sitter> findByOrderByAverageRating();
			

}
