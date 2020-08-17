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

import com.Cyanurzz.SupremeOtter.entity.contentGame.Content;
import com.Cyanurzz.SupremeOtter.repository.ContentRepository;
import com.Cyanurzz.SupremeOtter.repository.GameRepository;

@RequestMapping("/admin/games/update/contents")
@Controller
public class GameContentAdminController {

	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private ContentRepository contentRepository;
	
	@GetMapping("/update")
	public String toGameAdminUpdate(Model model,@RequestParam("game") Integer game, @RequestParam(required= false) Integer id) {
		Content content = new Content();
		if (id != null) {
			Optional<Content> optionalContent = contentRepository.findById(id);
			if (optionalContent.isPresent()) {
				content = optionalContent.get();
			}
		}
		
		model.addAttribute("game", gameRepository.findById(game).get());
		model.addAttribute("content", content);
		
		return "gameContentAdminUpdate";
	}
	
	@PostMapping("/update")
	public String create(RedirectAttributes redirAttrs, Model model, @RequestParam("game") Integer game, @RequestParam(required = false) Integer id, @Valid  Content content, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "gameContentAdminUpdate";
		}
		if( id == null) {
			
			redirAttrs.addFlashAttribute("sucessMessage", "Nouvelle description créé");
		}else {
			redirAttrs.addFlashAttribute("sucessMessage", "La description à été modifié");
		}
		contentRepository.save(content);
		
		return "redirect:/admin/games/update?id=" + game;
	}
	
	@GetMapping("/delete")
	public String delete(RedirectAttributes redirAttrs, @RequestParam Integer id, @RequestParam("game") Integer game) {
		
		Content contentToDelete = contentRepository.findById(id).get();
		contentRepository.delete(contentToDelete);
		redirAttrs.addFlashAttribute("sucessMessage", "Le contenue vient d'etre supprimé");
		
		return "redirect:/admin/games/update?id=" + game;
	}
}
