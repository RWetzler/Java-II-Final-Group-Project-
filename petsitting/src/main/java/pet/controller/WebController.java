package pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import pet.beans.Job;
import pet.beans.Owner;
import pet.beans.Sitter;
import pet.repository.JobRepository;
import pet.repository.OwnerRepository;
import pet.repository.SitterRepository;

@Controller
public class WebController {
	
	@Autowired
	JobRepository jobRepo;
	
	@Autowired
	OwnerRepository ownerRepo;

	@Autowired
	SitterRepository sitterRepo;
	
	@RequestMapping(value = "ownerHome")
	@GetMapping({ "/ownerHome" })
	public String viewOwner(Model model) {
		if(ownerRepo.findAll().isEmpty()) {
			return addNewOwner(model);
		}
		
		model.addAttribute("owners", ownerRepo.findAll());
		
		return "ownerHome";
	}
	
	@GetMapping("/insertOwner")
	public String addNewOwner(Model model) {
		Owner owner = new Owner();
		
		model.addAttribute("newOwner", owner);
		return "insertOwner";
	}
	
	@GetMapping("/rateSitter")
	public String rateSitter(Model model) {
		Owner owner = new Owner();
		Sitter sitter = new Sitter();
		Job job = new Job();
		
		model.addAttribute("newOwner", owner);
		model.addAttribute("newSitter", sitter);
		model.addAttribute("newJob", job);
		return "rateSitter";
	}
	
	@GetMapping({ "/sitterHome" })
	public String viewSitter(Model model) {
		if(ownerRepo.findAll().isEmpty()) {
			return addNewSitter(model);
		}
		
		model.addAttribute("owners", ownerRepo.findAll());
		model.addAttribute("sitters", sitterRepo.findAll());
		model.addAttribute("jobs", jobRepo.findAll());
		
		return "sitterHome";
	}
	
	@GetMapping("/insertSitter")
	public String addNewSitter(Model model) {
		Sitter sitter = new Sitter();
		
		model.addAttribute("newSitter", sitter);
		return "insertSitter";
	}
}
