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
import com.Cyanurzz.SupremeOtter.entity.contentGame.Platform;
import com.Cyanurzz.SupremeOtter.repository.PlatformRepository;
import com.Cyanurzz.SupremeOtter.repository.TagRepository;

@RequestMapping("/admin/platforms")
@Controller
public class PlatformAdminController {

	
	@Autowired
	PlatformRepository platformRepository;
	
	@Autowired
	TagRepository tagRepository;
	
	@GetMapping
	public String toPlaformAdminUpdate(Model model, @RequestParam(required= false) Integer id) {
		
		Platform platform = new Platform();
		if (id != null) {
			Optional<Platform> optionalPlatform = platformRepository.findById(id);
			if (optionalPlatform.isPresent()) {
				platform = optionalPlatform.get();
			}
		}
		model.addAttribute("platforms", platformRepository.findAll());
		model.addAttribute("platform", platform);
		
		
		return "platformsAdmin";
	}
	
	@PostMapping("/update")
	public String create(RedirectAttributes redirAttrs, Model model, @RequestParam(required = false) Integer id, @Valid  Platform platform, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("platforms", platformRepository.findAll());
			return "platformsAdmin";
		}
		if( id == null) {
			
			Tag tag = new Tag();
			tag.setName(platform.getName().toLowerCase());
			tag.setKey("platform");
			tagRepository.save(tag);
			redirAttrs.addFlashAttribute("sucessMessage", "Nouvelle platforme créé");
		}else {
			
			redirAttrs.addFlashAttribute("sucessMessage", "La platforme a été modifié");
		}
		
		platformRepository.save(platform);
		
		return "redirect:/admin/platforms";
	}
	
	@GetMapping("/delete")
	public String delete(RedirectAttributes redirAttrs, @RequestParam Integer id) {
		
		Platform platformToDelete = platformRepository.findById(id).get();
		platformRepository.delete(platformToDelete);
		redirAttrs.addFlashAttribute("sucessMessage", "La platforme vient d'etre supprimé");
		
		return "redirect:/admin/platforms";
	}

}

