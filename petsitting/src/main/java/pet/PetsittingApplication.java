package pet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("pet.controller")
@SpringBootApplication
public class PetsittingApplication {


	public static void main(String[] args) {
		SpringApplication.run(PetsittingApplication.class, args);
		
	}
}
