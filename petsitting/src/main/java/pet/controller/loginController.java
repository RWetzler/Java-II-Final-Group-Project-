package pet.controller;

import java.sql.Array;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pet.beans.Owner;
import pet.beans.Pet;
import pet.beans.Sitter;
import pet.repository.JobRepository;
import pet.repository.OwnerRepository;
import pet.repository.PetRepository;
import pet.repository.SitterRepository;

@Controller
public class loginController {

	@Autowired
	OwnerRepository ownerRepo;

	@Autowired
	SitterRepository sitterRepo;
	
	@Autowired
	PetRepository petRepo;

	@Autowired
	JobRepository jobRepo;

	@PostMapping("/ownerHome/{ownerId}")
	public String loginOwner(Owner owner, Model model) {
		String userName = owner.getUserName();
		String passWord = owner.getPassWord();
		List<Owner> findOwner = ownerRepo.findAll();
		for (Owner ownerLoop : findOwner) {
			if (ownerLoop.getUserName().contentEquals(userName)) {
				if (ownerLoop.getPassWord().contentEquals(passWord)) {
					if (ownerRepo.findAll().isEmpty()) {
						return "insertOwner";
					}

					model.addAttribute("owners", ownerRepo.findAll());
					model.addAttribute("pets", petRepo.findAll());

					return "ownerHome";
				}
			}

		}

		return viewOwner(model);
	}

	@GetMapping("/loginOwner")
	public String findOwner(Model model) {
		Owner o = new Owner();
		model.addAttribute("loginOwner", o);

		return "ownerLoginIndex";
	}
	
	@GetMapping("/viewOwner/{ownerId}")
	public String viewOwner(Model model) {
		model.addAttribute("owners", ownerRepo.findAll());
		model.addAttribute("pets", petRepo.findAll());

		return "ownerHome";
	}

	@GetMapping("/loginSitter")
	public String findSitter(Model model) {
		Sitter s = new Sitter();
		model.addAttribute("loginSitter", s);

		return "sitterLoginIndex";
	}

	@PostMapping("/sitterHome/{sitterId}")
	public String loginSitter(Sitter sitter, Model model) {
		String userName = sitter.getUserName();
		String passWord = sitter.getPassWord();
		List<Sitter> findSitter = sitterRepo.findAll();
		for (Sitter sitterLoop : findSitter) {
			if (sitterLoop.getUserName().contentEquals(userName)) {
				if (sitterLoop.getPassWord().contentEquals(passWord)) {
					if (sitterRepo.findAll().isEmpty()) {
						return "insertSitter";
					}

					model.addAttribute("owners", ownerRepo.findAll());
					model.addAttribute("sitters", sitterRepo.findAll());
					model.addAttribute("jobs", jobRepo.findAll());

					return "sitterHome";
				}
			}

		}

		return findSitter(model);
	}
	
	@GetMapping("/viewSitter/{sitterId}")
	public String viewSitter(Model model) {
		model.addAttribute("sitters", sitterRepo.findAll());

		return "sitterHome";
	}

}
