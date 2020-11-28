package pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = "rateSitter")
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
	
	@GetMapping("acceptJob")
	public String acceptJob(@RequestParam(name="job", required=true) String theChoice, Model model)
	{
		if(theChoice == "Accept")
			status = Job("Accepted");
			return "Accepted";
		else
			status = Job("Rejected");
			return "Rejected";
	}
	


}
