package it.beTalent.nomiCognomi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import it.beTalent.nomiCognomi.entities.Person;
import it.beTalent.nomiCognomi.service.VGService;

@Controller
public class VGController {

	@Autowired
	VGService vgService;
	
	/*@GetMapping("/")
	public String viewHomePage(Model model) {
		
		List<Person> listPeople = vgService.listAll();
		model.addAttribute("listPeople", listPeople);
		return "index";
		
	}*/
	
	@GetMapping("/dashboard")
	public String viewDashPage(Model model) {
		
		List<Person> listPeople = vgService.listAll();
		model.addAttribute("listPeople", listPeople);
		return "dashboard";
		
	}
	
	
	
	
	@GetMapping("/new")
	public String showNewPersonPage(Model model) {
		Person persona = new Person();
		model.addAttribute("person", persona);
		return "addPerson";
	}
	
	@GetMapping("/addPerson")
	public String savePerson(@ModelAttribute("person") Person persona) {
		vgService.save(persona);
		return "redirect:/";
		
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView showEditPerson(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit-person");
		Person persona = vgService.get(id);
		mav.addObject("persona", persona);
		return mav;
	}
	
	@GetMapping("/delete/{id}")
	public String deletePerson(@PathVariable(name = "id") int id) {
		vgService.delete(id);
		return "redirect:/";
	}
	
	/*@RequestMapping("/register")
	public String registerUser(@ModelAttribute("user") User user) {
		User user = new User();
		user.saveUser(user);
		// Implement the registration logic here
	    // Save the user to the database or perform any other necessary actions
	    return "redirect:/login"; // Redirect to the login page after successful registration
	}
	*/
	
	/*@RequestMapping("/search")
	public String findByCat(@RequestParam("category") String category, Model model) {
		List<Person> listPeople = vgService.findByCat(category);
		model.addAttribute("listaPersone", listPeople);
		return "index";
	}*/
	
	
	
}
