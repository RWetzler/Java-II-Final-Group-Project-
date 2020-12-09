package pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;




import pet.beans.Job;

import pet.beans.Owner;
import pet.beans.Sitter;
import pet.repository.AddressRepository;
import pet.repository.JobRepository;
import pet.repository.OwnerRepository;
import pet.repository.PetRepository;
import pet.repository.SitterRepository;

@Controller
public class OwnerController {

	@Autowired
	JobRepository jobRepo;
	
	@Autowired
	OwnerRepository ownerRepo;

	@Autowired
	SitterRepository sitterRepo;
	
	@Autowired
	PetRepository petRepo;
	
	@Autowired
	AddressRepository addressRepo;
	
	@RequestMapping(value = "ownerHome")
	@GetMapping({ "/ownerHome" })
	public String viewOwner(Model model) {
		if (ownerRepo.findAll().isEmpty()) {
			return addNewOwner(model);
		}
		
		model.addAttribute("owners", ownerRepo.findAll());

		return "ownerHome";
	}

	@RequestMapping(value = "insertOwner")
	@GetMapping("/insertOwner")
	public String addNewOwner(Model model) {
		Owner owner = new Owner();

		model.addAttribute("newOwner", owner);
		return "insertOwner";
	}


	@GetMapping("/edit/1/{ownerId}")
	public String showUpdateOwner(@PathVariable("ownerId") Long id, Model model) {
		Owner owner = ownerRepo.findById(id).orElse(null);
		
		System.out.println("PROFILE TO EDIT: " + owner.toString());
		
		model.addAttribute("newOwner", owner);
		return "insertOwner";
	}

	@PostMapping("/update/1/{ownerId}")
	public String reviseOwner(Owner owner, Model model) {
		ownerRepo.save(owner);
		
		return viewOwner(model);
	}
	
	
	@GetMapping("/delete/1/{ownerId}")
	public String deleteOwner(@PathVariable("ownerId") Long id, Model model) {
		Owner owner = ownerRepo.findById(id).orElse(null);
		ownerRepo.delete(owner);
		
	    return viewOwner(model);
	}
	
	@RequestMapping(value = "booking")
	@GetMapping({ "/booking" })
	public String booking(Model model) {
		
		model.addAttribute("owners", ownerRepo.findAll());
		model.addAttribute("sitters", sitterRepo.findAll());
		model.addAttribute("jobs", jobRepo.findAll());

		return "booking";
	}
}
