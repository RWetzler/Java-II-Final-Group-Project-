package pet.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pet.beans.Job;
import pet.beans.Owner;
import pet.beans.Sitter;

@Configuration
public class BeanConfiguration {

	//New instance of Video Game
	@Bean
	public Owner owner() {
		Owner bean = new Owner("Dale", "OwnerTester", "daleTester", "password", "555-123-1234", "dtester@gmail.com", "n/a", "Buddy", "Dog", "HeartWorm Medication");
		return bean;
	}

	//New instance of Genre
	@Bean
	public Sitter sitter() {
		Sitter bean = new Sitter("Nancy", "Tester", "nancyTester", "password", "555-555-5555","ntester@gmail.com","n/a","none", 3, 5.0, job(), job());
		return bean;
	}
	
	//New instance of Console
	@Bean
	public Job job() {
		Job bean = new Job (5, "Great Job!");
		return bean;
	}
}