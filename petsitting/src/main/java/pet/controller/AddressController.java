package pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pet.beans.Address;
import pet.repository.AddressRepository;
import pet.repository.OwnerRepository;
import pet.repository.SitterRepository;

public class AddressController {
	@Autowired
	AddressRepository repo;
	
	@Autowired
	OwnerRepository ownerRepo;

	@Autowired
	SitterRepository sitterRepo;
	
	@GetMapping({"viewAll" })
	public String viewAllAddresses(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewAddress(model);
			}
		model.addAttribute("address",repo.findAll());
		return "results";
	}	
	
	@GetMapping({"viewAllOwners" })
	public String viewAllOwner(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewAddress(model);
			}
		model.addAttribute("owners",repo.findAll());
		return "results";
	}
	@GetMapping({"viewAllSitters" })
	public String viewAllSitters(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewAddress(model);
			}
		model.addAttribute("sitters",repo.findAll());
		return "results";
	}
	@GetMapping("/inputAddress")
		public String addNewAddress(Model model) {
		Address a = new Address();
		model.addAttribute("newAddress", a);
		viewAllOwner(model);
		return "input";
	}
	@PostMapping("/inputAddress")
	public String addNewAddress(@ModelAttribute Address a, Model model) {
	repo.save(a);
	return viewAllAddresses(model);
	
}
	@GetMapping("/edit/{id}")
	public String showUpdateAddress(@PathVariable("id") long id,Model model) {
	Address a = repo.findById(id).orElse(null);
	model.addAttribute("newAddress", a);
	return "input";
	}
	@PostMapping("/update/{id}")
	public String reviseAddress(Address a, Model model) {
	repo.save(a);
	return viewAllAddresses(model);
	}
	@GetMapping("/delete/{id}")
	public String deleteAddress(@PathVariable("id") long id, Model model) {
	Address a = repo.findById(id).orElse(null);
	 repo.delete(a);
	 return viewAllAddresses(model);
	}
}
