package com.Cyanurzz.ProjectTitan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Cyanurzz.ProjectTitan.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
