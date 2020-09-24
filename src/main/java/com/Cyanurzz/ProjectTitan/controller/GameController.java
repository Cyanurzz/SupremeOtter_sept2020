package com.Cyanurzz.ProjectTitan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Cyanurzz.ProjectTitan.entity.Game;
import com.Cyanurzz.ProjectTitan.repository.ArticleRepository;
import com.Cyanurzz.ProjectTitan.repository.GameRepository;


@Controller
public class GameController {
	
	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	GameRepository gameRepository;
	
	@RequestMapping("/games")
	public String toGames(Model model) {
		
		model.addAttribute("games", gameRepository.findAll());
		return "games";
	}
	
	@RequestMapping("/game/{id}")
	public String toGame(Model model, @PathVariable Integer id) {
		
		Game game = gameRepository.findById(id).get();
		
		model.addAttribute("articles", articleRepository.findAllByGame(game));
		model.addAttribute("game", game);
		return "game";
	}

}
