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

import com.Cyanurzz.SupremeOtter.entity.Game;
import com.Cyanurzz.SupremeOtter.repository.DescriptorRepository;
import com.Cyanurzz.SupremeOtter.repository.GameRepository;
import com.Cyanurzz.SupremeOtter.repository.GenderRepository;
import com.Cyanurzz.SupremeOtter.repository.PlatformRepository;
import com.Cyanurzz.SupremeOtter.repository.TagRepository;

@RequestMapping("/admin/games")
@Controller
public class GameAdminController {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private TagRepository tagRepository;
	
	@Autowired
	private PlatformRepository platformRepository;
	
	@Autowired
	private GenderRepository genderRepository;
	
	@Autowired
	private DescriptorRepository descriptorRepository;
	
	@GetMapping
	public String toGamesAdmin(Model model) {
		model.addAttribute("games", gameRepository.findAll());
		return "gameAdmin";
	}
	
	@GetMapping("/update")
	public String toGameAdminUpdate(Model model, @RequestParam(required= false) Integer id) {
		
		Game game = new Game();
		if (id != null) {
			Optional<Game> optionalGame = gameRepository.findById(id);
			if (optionalGame.isPresent()) {
				game = optionalGame.get();
			}
		}
		
		model.addAttribute("tags", tagRepository.findAll());
		model.addAttribute("descriptors", descriptorRepository.findAll());
		model.addAttribute("platforms", platformRepository.findAll());
		model.addAttribute("genders", genderRepository.findAll());
		model.addAttribute("game", game);
		
		return "gameAdminUpdate";
	}
	
	@PostMapping("/update")
	public String create(RedirectAttributes redirAttrs, Model model, @RequestParam(required = false) Integer id, @Valid  Game game, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "gameAdminUpdate";
		}
		if( id == null) {
			
			redirAttrs.addFlashAttribute("sucessMessage", "Nouveau jeu créé");
		}else {
			
			redirAttrs.addFlashAttribute("sucessMessage", "Le jeux à été modifié");
		}
		gameRepository.save(game);
		
		return "redirect:/admin/games";
	}
	
	@GetMapping("/delete")
	public String delete(RedirectAttributes redirAttrs, @RequestParam Integer id) {
		
		Game gameToDelete = gameRepository.findById(id).get();
		gameRepository.delete(gameToDelete);
		redirAttrs.addFlashAttribute("sucessMessage", "Le jeu vient d'etre supprimé");
		
		return "redirect:/admin/games";
	}

}
