package com.Cyanurzz.SupremeOtter.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Cyanurzz.SupremeOtter.entity.User;
import com.Cyanurzz.SupremeOtter.repository.UserRepository;

@Controller
@RequestMapping("/admin/users")
public class UserAdminController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping
	public String toUserAdmin(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "usersAdmin";
	}
	
	@GetMapping("/update")
	public String toArticleAdminUpdate(Model model, @RequestParam(required= false) Integer id) {
		
		User user = new User();
		if (id != null) {
			Optional<User> optionalUser = userRepository.findById(id);
			if (optionalUser.isPresent()) {
				user = optionalUser.get();
			}
		}
		model.addAttribute("user", user);
		
		return "userAdminUpdate";
	}
	
	
	/** Trouvé moyen de bloqué modif password **/
	@PostMapping("/update")
	public String create(RedirectAttributes redirAttrs, Model model, @Valid User user, BindingResult bindingResult) {
		
		
		if (bindingResult.hasErrors()) {
			redirAttrs.addFlashAttribute("sucessMessage", "ERROR#!");
			return "userAdminUpdate";
		}
		if( user.getId() == null) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			redirAttrs.addFlashAttribute("sucessMessage", "Nouvel utilisateur créé");
		}else {
			user.setPassword(user.getPassword());
			redirAttrs.addFlashAttribute("sucessMessage", "L'utilisateur à été modifié");
			
		}
		userRepository.save(user);
		
		return "redirect:/admin/users";
	}
	
	@GetMapping("/delete")
	public String delete(RedirectAttributes redirAttrs, @RequestParam Integer id) {
		
		User userToDelete = userRepository.findById(id).get();
		userRepository.delete(userToDelete);
		redirAttrs.addFlashAttribute("sucessMessage", "L'utilisateur vient d'etre supprimé");
		
		return "redirect:/admin/users";
	}

}
