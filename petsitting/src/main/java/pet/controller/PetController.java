package pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pet.beans.Owner;
import pet.beans.Pet;
import pet.repository.OwnerRepository;
import pet.repository.PetRepository;


@Controller
public class PetController{
	@Autowired
	PetRepository pRepo;
	
	@Autowired
	OwnerRepository oRepo;
	
	@GetMapping({"/ownerLoggedIn" })
	public String viewAllPets(Model model) {
		if(pRepo.findAll().isEmpty()) {
			return addNewPet(model);
			}
		model.addAttribute("owners", oRepo.findAll());
		model.addAttribute("pets",pRepo.findAll());
		return "ownerHome";
	}	

	@GetMapping("/insertPet")
		public String addNewPet(Model model) {
		Pet p = new Pet();
		
		model.addAttribute("newPet", p);
		return "insertPet";
	}

	@GetMapping("/edit/4/{petId}")
	public String showUpdatePet(@PathVariable("petId") long id,Model model) {
	Pet p = pRepo.findById(id).orElse(null);
	model.addAttribute("newPet", p);
	return "insertPet";
	}
	
	@PostMapping("/update/4/{petId}")
	public String revisePet(Pet p, Model model) {
	pRepo.save(p);
	
	return viewAllPets(model);
	}
	
	@GetMapping("/delete/4/{petId}")
	public String deletePet(@PathVariable("petId") long id, Model model) {
	Pet p = pRepo.findById(id).orElse(null);
	 pRepo.delete(p);
	 return viewAllPets(model);
	}
}
