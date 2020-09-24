package com.Cyanurzz.ProjectTitan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Cyanurzz.ProjectTitan.entity.Article;
import com.Cyanurzz.ProjectTitan.repository.ArticleRepository;

@Controller
public class ArticleController {

	@Autowired
	ArticleRepository articleRepository;
	
	@RequestMapping("/articles")
	public String toArticles(Model model) {
		
		model.addAttribute("articles", articleRepository.findAll());
		return "articles";
	}
	
	@RequestMapping("/article/{id}")
	public String toArticle(Model model, @PathVariable Integer id) {
		
		Article article = articleRepository.findById(id).get();
		
		model.addAttribute("articles", articleRepository.findAllByGame(article.getGame()));
		model.addAttribute("article", article);
		return "article";
	}
}
