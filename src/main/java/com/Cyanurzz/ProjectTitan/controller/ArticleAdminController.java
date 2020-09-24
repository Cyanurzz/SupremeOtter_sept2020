package com.Cyanurzz.ProjectTitan.controller;

import java.security.Principal;
import java.util.Date;
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

import com.Cyanurzz.ProjectTitan.entity.Article;
import com.Cyanurzz.ProjectTitan.repository.ArticleRepository;
import com.Cyanurzz.ProjectTitan.repository.GameRepository;
import com.Cyanurzz.ProjectTitan.repository.TagRepository;
import com.Cyanurzz.ProjectTitan.repository.UserRepository;

@RequestMapping("/admin/articles")
@Controller
public class ArticleAdminController {

	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private TagRepository tagRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private GameRepository	gameRepository;
	
	@GetMapping
	public String toArticlesAdmin(Model model) {
		model.addAttribute("articles", articleRepository.findAll());
		
		return "articlesAdmin";
	}
	
	@GetMapping("/update")
	public String toArticleAdminUpdate(Model model, @RequestParam(required= false) Integer id) {
		
		Article article = new Article();
		if (id != null) {
			Optional<Article> optionalArticle = articleRepository.findById(id);
			if (optionalArticle.isPresent()) {
				article = optionalArticle.get();
			}
		}
		
		
		model.addAttribute("article", article);
		model.addAttribute("games", gameRepository.findAll());
		model.addAttribute("tags", tagRepository.findAll());
		
		return "articleAdminUpdate";
	}
	
	@PostMapping("/update")
	public String create(RedirectAttributes redirAttrs, Model model, @RequestParam(required = false) Integer id, @Valid  Article article, BindingResult bindingResult, Principal principal) {
		

		if( id == null) {
			redirAttrs.addFlashAttribute("sucessMessage", "Nouvel article créé");
		}else {
			redirAttrs.addFlashAttribute("sucessMessage", "L'Article à été modifié");
		}
	    Date date = new Date();  

	    article.setAuthor(userRepository.findByUsername(principal.getName()));
	    article.setReleaseDate(date);

		
		articleRepository.save(article);
		
		return "redirect:/admin/articles";
	}
	
	@GetMapping("/delete")
	public String delete(RedirectAttributes redirAttrs, @RequestParam Integer id) {
		
		Article articleToDelete = articleRepository.findById(id).get();
		articleRepository.delete(articleToDelete);
		redirAttrs.addFlashAttribute("sucessMessage", "L'article vient d'etre supprimé");
		
		return "redirect:/admin/articles";
	}
}
