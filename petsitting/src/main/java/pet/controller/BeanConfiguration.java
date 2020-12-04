package pet.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import pet.beans.Job;
import pet.beans.Owner;
import pet.beans.Pet;
import pet.beans.Sitter;

@Configuration
public class BeanConfiguration {

	//New instance of Owner
	@Bean
	public Owner owner() {
		Owner bean = new Owner("Dale", "OwnerTester", "daleTester", "password", "555-123-1234", "dtester@gmail.com", "n/a");
		return bean;
	}

	//New instance of Sitter
	@Bean
	public Sitter sitter() {
		Sitter bean = new Sitter("Nancy", "Tester", "nancyTester", "password", "555-555-5555","ntester@gmail.com","n/a","none", 3, "Test Bigography", 5.0);
		return bean;
	}
	
	//New instance of Job
	@Bean
	public Job job() {
		Job bean = new Job (5, "Great Job!","", "Accepted", LocalDate.parse("2020-12-01"), LocalTime.parse("13:30:00"));
		return bean;
	}
	
	//New Instance of Pet
	@Bean
	public Pet pet() {
		Pet bean = new Pet ("Buddy", "Daschund", "Heart Worm");
		return bean;
	}
}