package com.Cyanurzz.SupremeOtter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Cyanurzz.SupremeOtter.repository.GameRepository;

@Controller
public class HomeController {

	
	@Autowired
	GameRepository gameRepository;
	
	@RequestMapping("/")
	public String welcome(Model model) {
		
		model.addAttribute("game", gameRepository.findAll());
		return "index";
	}

}

