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
import com.Cyanurzz.ProjectTitan.entity.contentGame.Descriptor;
import com.Cyanurzz.ProjectTitan.repository.DescriptorRepository;
import com.Cyanurzz.ProjectTitan.repository.TagRepository;

@Controller
@RequestMapping("/admin/descriptors")
public class descriptorAdminController {

	
	@Autowired
	DescriptorRepository descriptorRepository;
	
	@Autowired
	TagRepository tagRepository;
	
	@GetMapping
	public String toPlaformAdminUpdate(Model model, @RequestParam(required= false) Integer id) {
		
		Descriptor descriptor = new Descriptor();
		if (id != null) {
			Optional<Descriptor> optionalDescriptor = descriptorRepository.findById(id);
			if (optionalDescriptor.isPresent()) {
				descriptor = optionalDescriptor.get();
			}
		}
		model.addAttribute("descriptors", descriptorRepository.findAll());
		model.addAttribute("descriptor", descriptor);
		
		
		return "descriptorsAdmin";
	}
	
	@PostMapping("/update")
	public String create(RedirectAttributes redirAttrs, Model model, @RequestParam(required = false) Integer id, @Valid  Descriptor descriptor, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("descriptors", descriptorRepository.findAll());
			return "descriptorsAdmin";
		}
		if( id == null) {
			
			Tag tag = new Tag();
			tag.setName(descriptor.getName().toLowerCase());
			tag.setKey("descriptor");
			tagRepository.save(tag);
			redirAttrs.addFlashAttribute("sucessMessage", "Nouveau descripteur créé");
		}else {
			
			redirAttrs.addFlashAttribute("sucessMessage", "La descripteur a été modifié");
		}
		
		descriptorRepository.save(descriptor);
		
		return "redirect:/admin/descriptors";
	}
	
	@GetMapping("/delete")
	public String delete(RedirectAttributes redirAttrs, @RequestParam Integer id) {
		
		Descriptor descriptorToDelete = descriptorRepository.findById(id).get();
		descriptorRepository.delete(descriptorToDelete);
		redirAttrs.addFlashAttribute("sucessMessage", "Le jeu vient d'etre supprimé");
		
		return "redirect:/admin/descriptors";
	}
}
