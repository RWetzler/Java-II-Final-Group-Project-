package pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pet.beans.Job;
import pet.beans.Sitter;
import pet.repository.JobRepository;
import pet.repository.OwnerRepository;
import pet.repository.SitterRepository;

@Controller
public class SitterController {

	@Autowired
	JobRepository jobRepo;
	
	@Autowired
	OwnerRepository ownerRepo;

	@Autowired
	SitterRepository sitterRepo;
	
	@RequestMapping(value = "sitterHome")
	@GetMapping({ "/sitterHome" })
	public String viewSitter(Model model) {
		if (sitterRepo.findAll().isEmpty()) {
			return addNewSitter(model);
		}

		model.addAttribute("owners", ownerRepo.findAll());
		model.addAttribute("sitters", sitterRepo.findAll());
		model.addAttribute("jobs", jobRepo.findAll());

		return "sitterHome";
	}

	@RequestMapping(value = "insertSitter")
	@GetMapping("/insertSitter")
	public String addNewSitter(Model model) {
		Sitter sitter = new Sitter();

		model.addAttribute("newSitter", sitter);
		return "insertSitter";
	}

	@GetMapping("/edit/2/{sitterId}")
	public String showUpdateSitter(@PathVariable("sitterId") Long id, Model model) {
		Sitter sitter = sitterRepo.findById(id).orElse(null);

		System.out.println("SITTER TO EDIT: " + sitter.toString());

		model.addAttribute("newSitter", sitter);
		return "insertSitter";
	}

	@PostMapping("/update/2/{sitterId}")
	public String reviseSitter(Sitter sitter, Model model) {
		sitterRepo.save(sitter);

		return viewSitter(model);
	}

	@GetMapping("/delete/2/{sitterId}")
	public String deleteSitter(@PathVariable("sitterId") Long id, Model model) {
		Sitter sitter = sitterRepo.findById(id).orElse(null);
		sitterRepo.delete(sitter);

		return viewSitter(model);
	}
	@RequestMapping(value = "viewJobs")
	@GetMapping({ "/viewJobs" })
	public String viewJobs(Model model) {
		model.addAttribute("owners", ownerRepo.findAll());
		model.addAttribute("sitters", sitterRepo.findAll());
		model.addAttribute("jobs", jobRepo.findAll());

		return "viewJobs";
	}
}