package it.beTalent.nomiCognomi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.beTalent.nomiCognomi.entities.Person;
import it.beTalent.nomiCognomi.entities.User;
import it.beTalent.nomiCognomi.service.UserService;

@Controller
public class UserController {
    
    @Autowired
    UserService uservice;
    
    @GetMapping("/")
    public String showLoginPage(Model model) {
    	List<User> listUser = uservice.listAll();
		model.addAttribute("listUser", listUser);
        return "index";
    }
    
    @GetMapping("/registration")
	public String showNewPersonPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "registration";
	}
    
    
    @PostMapping("/registration")
    public String processRegistration(@ModelAttribute("user") User user) {
        // Salva il nuovo utente nel database
    	
    	uservice.saveUser(user);
        return "redirect:/login";
    }
    
   
    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String username, 
                               @RequestParam("password") String password) {
    	List<User> users = uservice.findByUsername(username);
        if (!users.isEmpty()) {
            User user = users.get(0);
            if (user.getPassword().equals(password)) {
                // Credenziali corrette, reindirizza all'area riservata
                return "redirect:/dashboard";
            }
        }
        
        // Credenziali errate o utente non trovato, reindirizza al login con un messaggio di errore
        return "redirect:/login?error";
    }
    
 
}
