package com.Cyanurzz.ProjectTitan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Cyanurzz.ProjectTitan.repository.ArticleRepository;
import com.Cyanurzz.ProjectTitan.repository.GameRepository;

@Controller
public class HomeController {

	
	@Autowired
	GameRepository gameRepository;
	
	@Autowired
	ArticleRepository articleRepository;
	
	@RequestMapping("/")
	public String welcome(Model model) {
		
		model.addAttribute("games", gameRepository.findAll());
		model.addAttribute("mainGames", gameRepository.retrieveMainGame());
		model.addAttribute("articles", articleRepository.findAll());
		return "index";
	}

}

