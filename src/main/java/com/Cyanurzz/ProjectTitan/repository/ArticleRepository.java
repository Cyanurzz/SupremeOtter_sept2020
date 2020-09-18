package com.Cyanurzz.ProjectTitan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Cyanurzz.ProjectTitan.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

	Optional<Article> findById(Integer id);
}
