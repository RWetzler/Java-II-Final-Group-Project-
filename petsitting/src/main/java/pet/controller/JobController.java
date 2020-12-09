/*package pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pet.beans.Job;
import pet.beans.Sitter;
import pet.repository.AddressRepository;
import pet.repository.JobRepository;
import pet.repository.OwnerRepository;
import pet.repository.PetRepository;
import pet.repository.SitterRepository;

public class JobController {

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
	
	@RequestMapping(value = "viewJobs")
	@GetMapping({ "/viewJobs" })
	public String viewJobs(Model model) {
		if (jobRepo.findAll().isEmpty()) {
			return addNewJob(model);
		}
		model.addAttribute("owners", ownerRepo.findAll());
		model.addAttribute("sitters", sitterRepo.findAll());
		model.addAttribute("jobs", jobRepo.findAll());

		return "viewJobs";
	}
	
	@RequestMapping(value = "insertJob")
	@GetMapping("/insertJob")
	public String addNewJob(Model model) {
		Job job = new Job();

		model.addAttribute("newJob", job);
		return "insertJob";
	}
	
	@GetMapping("/edit/3/{jobId}")
	public String showUpdateJob(@PathVariable("jobId") Long id, Model model) {
		Job job = jobRepo.findById(id).orElse(null);

		System.out.println("JOB TO EDIT: " + job.toString());

		model.addAttribute("newJob", job);
		return "insertJob";
	}
	
	@PostMapping("/update/3/{jobId}")
	public String reviseJob(Job job, Model model) {
		jobRepo.save(job);
		
		return viewJobs(model);
	}
}
*/