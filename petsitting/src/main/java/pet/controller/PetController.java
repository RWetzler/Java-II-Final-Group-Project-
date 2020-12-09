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
	
	
	
	@GetMapping({"viewAll" })
	public String viewAllPets(Model model) {
		if(pRepo.findAll().isEmpty()) {
			return addNewPet(model);
			}
		model.addAttribute("pets",pRepo.findAll());
		return "/ownerHome";
	}	


	

	@GetMapping("/inputPet")
		public String addNewPet(Model model) {
		Pet p = new Pet();
		model.addAttribute("newPet", p);
		if(oRepo.findAll().isEmpty()) {
			return "/ownerHome";
			}
		model.addAttribute("owners",oRepo.findAll());
		return "insertPet";
	}
	@PostMapping("/inputPet")
	public String addNewPet(@ModelAttribute Pet p, Model model) {
	pRepo.save(p);
	return "ownerHome";
	
}
	@GetMapping("/edit/{id}")
	public String showUpdatePet(@PathVariable("id") long id,Model model) {
	Pet p = pRepo.findById(id).orElse(null);
	model.addAttribute("newPet", p);
	return "input";
	}
	@PostMapping("/update/{id}")
	public String revisePet(Pet p, Model model) {
	pRepo.save(p);
	
	return "/ownerHome";
	}
	@GetMapping("/delete/{id}")
	public String deletePet(@PathVariable("id") long id, Model model) {
	Pet p = pRepo.findById(id).orElse(null);
	 pRepo.delete(p);
	 return viewAllPets(model);
	}
}
