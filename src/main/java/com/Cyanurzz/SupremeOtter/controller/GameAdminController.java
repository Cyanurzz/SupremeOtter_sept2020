package com.Cyanurzz.SupremeOtter.controller;

import java.util.ArrayList;
import java.util.List;
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
import com.Cyanurzz.SupremeOtter.entity.Tag;
import com.Cyanurzz.SupremeOtter.entity.contentGame.Descriptor;
import com.Cyanurzz.SupremeOtter.entity.contentGame.Gender;
import com.Cyanurzz.SupremeOtter.entity.contentGame.Platform;
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
		
		List<Tag> tags = new ArrayList(); //Initialize Tag list
		
		if (bindingResult.hasErrors()) {
			return "gameAdminUpdate";
		}
		if( id == null) { // IF id is null create tag with the game name and add it to the empty list
			
			Tag tag = new Tag();
			tag.setName(game.getTitle().toLowerCase());
			tagRepository.save(tag);
			tags.add(tag);
			redirAttrs.addFlashAttribute("sucessMessage", "Nouveau jeu créé");
		}else {
			redirAttrs.addFlashAttribute("sucessMessage", "Le jeux à été modifié");
		}
		
		// Then for each under category find the tag and push it into the list ... by this way search info will be much easier
		for(Platform platform: game.getPlatforms()) {	
			tags.add(tagRepository.findByName(platform.getName().toLowerCase()));
		}
		for(Descriptor descriptor: game.getDescriptors()) {
			tags.add(tagRepository.findByName(descriptor.getName().toLowerCase()));
		}
		for(Gender gender: game.getGenders()) {
			tags.add(tagRepository.findByName(gender.getName().toLowerCase()));
		}
		game.setTags(tags); // Then Attribute the list to the game
	
		
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
