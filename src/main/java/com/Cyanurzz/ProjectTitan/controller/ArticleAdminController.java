package com.Cyanurzz.ProjectTitan.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Cyanurzz.ProjectTitan.entity.Article;
import com.Cyanurzz.ProjectTitan.entity.Tag;
import com.Cyanurzz.ProjectTitan.repository.ArticleRepository;
import com.Cyanurzz.ProjectTitan.repository.TagRepository;
import com.Cyanurzz.ProjectTitan.repository.UserRepository;
import com.Cyanurzz.ProjectTitan.service.FileUpload;

@RequestMapping("/admin/articles")
@Controller
public class ArticleAdminController {

	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private TagRepository tagRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	private String DIR = "";

	@Autowired
	private FileUpload fileUpload;
	
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
		model.addAttribute("tags", tagRepository.findAll());
		
		return "articleAdminUpdate";
	}
	
	@PostMapping("/update")
	public String create(RedirectAttributes redirAttrs, Model model, @RequestParam(required = false) Integer id, @RequestParam() String title, @RequestParam() String content, @RequestParam("banner") MultipartFile banner, @RequestParam() List<Tag> tags) {
		
		String path = "";
		if (id != null) {
			path = articleRepository.findById(id).get().getBanner();
		}
		if (!banner.isEmpty()) {
			String fileName = "article_" + title.replaceAll(" ", "_").toLowerCase();
			path = fileUpload.writeFile(banner, DIR, fileName);
		}
		if( id == null) {
			redirAttrs.addFlashAttribute("sucessMessage", "Nouvel article créé");
		}else {
			redirAttrs.addFlashAttribute("sucessMessage", "L'Article à été modifié");
		}
		Article article = new Article();
	    Date date = new Date();  
	    article.setId(id);
	    article.setTitle(title);
	    article.setContent(content);
	    article.setAuthor(userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
	    article.setReleaseDate(date);
	    article.setTags(tags);
		article.setBanner(path);
		
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
