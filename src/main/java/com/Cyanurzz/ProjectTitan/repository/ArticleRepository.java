package com.Cyanurzz.ProjectTitan.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Cyanurzz.ProjectTitan.entity.Article;
import com.Cyanurzz.ProjectTitan.entity.Game;
import com.Cyanurzz.ProjectTitan.entity.Tag;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
	
	List<Article> findAllByGame(Game game);
	
	@Query("SELECT a FROM Article a JOIN a.tags t WHERE t = LOWER(:tag)")
	List<Article> retrieveByTag(@Param("tag") String tag);
	
	@Query(value="select a from Article a order by releaseDate desc")
	List<Article> findArticleMain();/// FInd limit
}
