package com.Cyanurzz.SupremeOtter.controller;

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

import com.Cyanurzz.SupremeOtter.entity.Tag;
import com.Cyanurzz.SupremeOtter.repository.TagRepository;

@RequestMapping("/admin/tags")
@Controller
public class TagAdminController {
	
	@Autowired
	TagRepository tagRepository;
	
	@GetMapping
	public String toTagAdminUpdate(Model model, @RequestParam(required= false) Integer id) {
		
		Tag tag = new Tag();
		if (id != null) {
			Optional<Tag> optionalTag = tagRepository.findById(id);
			if (optionalTag.isPresent()) {
				tag = optionalTag.get();
			}
		}
		model.addAttribute("tags", tagRepository.findAll());
		model.addAttribute("tag", tag);
		
		
		return "tagsAdmin";
	}
	
	@PostMapping("/update")
	public String create(RedirectAttributes redirAttrs, Model model, @RequestParam(required = false) Integer id, @Valid  Tag tag, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("tags", tagRepository.findAll());
			return "tagsAdmin";
		}
		if( id == null) {

			redirAttrs.addFlashAttribute("sucessMessage", "Nouveau tag créé");
		}else {
			
			redirAttrs.addFlashAttribute("sucessMessage", "Tag a été modifié");
		}
		
		tagRepository.save(tag);
		
		return "redirect:/admin/tags";
	}
	
	@GetMapping("/delete")
	public String delete(RedirectAttributes redirAttrs, @RequestParam Integer id) {
		
		Tag tagToDelete = tagRepository.findById(id).get();
		tagRepository.delete(tagToDelete);
		redirAttrs.addFlashAttribute("sucessMessage", "Le tag vient d'etre supprimé");
		
		return "redirect:/admin/tags";
	}
}
