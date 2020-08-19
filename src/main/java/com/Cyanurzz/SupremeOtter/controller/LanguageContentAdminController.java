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

import com.Cyanurzz.SupremeOtter.entity.Language;
import com.Cyanurzz.SupremeOtter.repository.GameRepository;
import com.Cyanurzz.SupremeOtter.repository.LanguageRepository;

@RequestMapping("/admin/games/content")
@Controller
public class LanguageContentAdminController {
	
	
	@Autowired
	LanguageRepository languageRepository;
	
	@Autowired
	GameRepository gameRepository;
	
	@GetMapping("/update")
	public String toGameAdminUpdate(Model model,@RequestParam("game") Integer game, @RequestParam(required= false) Integer id) {
		Language language = new Language();
		if (id != null) {
			Optional<Language> optionalLanguage = languageRepository.findById(id);
			if (optionalLanguage.isPresent()) {
				language = optionalLanguage.get();
			}
		}
		
		model.addAttribute("game", gameRepository.findById(game).get());
		model.addAttribute("language", language);
		
		return "gameContentAdminUpdate";
	}
	
	@PostMapping("/update")
	public String create(RedirectAttributes redirAttrs, Model model, @RequestParam("game") Integer game, @RequestParam(required = false) Integer id, @Valid  Language language, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "gameContentAdminUpdate";
		}
		if( id == null) {
			
			redirAttrs.addFlashAttribute("sucessMessage", "Nouvelle description créé");
		}else {
			redirAttrs.addFlashAttribute("sucessMessage", "La description à été modifié");
		}
		languageRepository.save(language);
		
		return "redirect:/admin/games/update?id=" + game;
	}
	
	@GetMapping("/delete")
	public String delete(RedirectAttributes redirAttrs, @RequestParam Integer id, @RequestParam("game") Integer game) {
		
		Language languageToDelete = languageRepository.findById(id).get();
		languageRepository.delete(languageToDelete);
		redirAttrs.addFlashAttribute("sucessMessage", "Le contenue vient d'etre supprimé");
		
		return "redirect:/admin/games/update?id=" + game;
	}
}
