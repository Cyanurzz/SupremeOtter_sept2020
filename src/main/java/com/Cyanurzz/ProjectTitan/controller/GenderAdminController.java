package com.Cyanurzz.ProjectTitan.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Cyanurzz.ProjectTitan.entity.Tag;
import com.Cyanurzz.ProjectTitan.entity.contentGame.Gender;
import com.Cyanurzz.ProjectTitan.repository.GenderRepository;
import com.Cyanurzz.ProjectTitan.repository.TagRepository;

@RequestMapping("/admin/genders")
@Controller
public class GenderAdminController {
	
	@Autowired
	GenderRepository genderRepository;
	
	@Autowired
	TagRepository tagRepository;
	
	@GetMapping
	public String toGenderAdminUpdate(Model model, @RequestParam(required=false) Integer id) {
		
		Gender gender = new Gender();
		if (id != null) {
			Optional<Gender> optionalGender = genderRepository.findById(id);
			if(optionalGender.isPresent()) {
				gender = optionalGender.get();
			}
		}
		
		model.addAttribute("genders", genderRepository.findAll());
		model.addAttribute("gender", gender);
		
		return "gendersAdmin";
	}

	@PostMapping("/update")
	public String create(RedirectAttributes redirAttrs, Model model, @RequestParam(required=false) Integer id, @Valid Gender gender, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("gender", genderRepository.findAll());
			return "gendersAdmin";
		}
		if( id == null) {
			
			Tag tag = new Tag();
			tag.setName(gender.getName().toLowerCase());
			tag.setKey("gender");
			tagRepository.save(tag);
			redirAttrs.addFlashAttribute("sucessMessage", "Nouveau genre ajouté");
		}else {
			
			redirAttrs.addFlashAttribute("sucessMessage", "genre modifié");
		}
		genderRepository.save(gender);
		
		return "redirect:/admin/genders";
	}
	
	@GetMapping("/delete")
	public String delete(RedirectAttributes redirAttrs, @RequestParam Integer id) {
		
		Gender genderToDelete = genderRepository.findById(id).get();
		genderRepository.delete(genderToDelete);
		redirAttrs.addFlashAttribute("sucessMessage", "Le genre vient d'etre supprimé");
		
		return "redirect:/admin/genders";
	}
}
