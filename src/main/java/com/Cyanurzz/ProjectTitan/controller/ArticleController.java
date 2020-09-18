package com.Cyanurzz.ProjectTitan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Cyanurzz.ProjectTitan.repository.ArticleRepository;

@Controller
public class ArticleController {

	@Autowired
	ArticleRepository articleRepository;
	
	@RequestMapping("/article/{id}")
	public String toArticle(Model model, @PathVariable Integer id) {
		
		model.addAttribute("article", articleRepository.findById(id).get());
		return "article";
	}
}
