package com.Cyanurzz.ProjectTitan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Cyanurzz.ProjectTitan.entity.Tag;
import com.Cyanurzz.ProjectTitan.repository.ArticleRepository;
import com.Cyanurzz.ProjectTitan.repository.GameRepository;
import com.Cyanurzz.ProjectTitan.repository.TagRepository;

@Controller
public class SearchController {
	
	@Autowired
	TagRepository tagRepository;

	@Autowired
	ArticleRepository articleRepository;
	
	@Autowired
	GameRepository gameRepository;
	
	@RequestMapping("/search/{id}")
	public String toSearch(Model model, @PathVariable Integer id) {
		
		Tag tag = tagRepository.findById(id).get();
		
		model.addAttribute("tag", tag);
		model.addAttribute("articles", articleRepository.retrieveByTag(tag.getName()));
		model.addAttribute("games", gameRepository.retrieveByTag(tag.getName()));
		
		return "search";
	}
}
