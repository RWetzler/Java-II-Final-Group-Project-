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
	public String acceptJob(@RequestParam(name="job", required=true) String theChoice, @PathVariable("id") long id, Model model)
	{
		Job j = jobRepo.findById(id).orElse(null);
		if(theChoice == "Accept") {
			j.status = "Accepted";
			jobRepo.save(j);
			return "Accepted";
		}
		else {
			j.status = "Rejected";
			jobRepo.save(j);
			return "Rejected";
		}
	}
	
	  @GetMapping("/viewSittersByMaxPets_{maxPets}")
		public String sortMaxPets(@PathVariable("maxPets") int maxPets, @PathVariable("numOfPets") int numOfPets, Model model) {
		  if(sitterRepo.findAll().isEmpty()) {
				return "insertSitter";
			}
		  model.addAttribute("sitters", sitterRepo.findAll());
		  return "sitterHome";
	  }
}
