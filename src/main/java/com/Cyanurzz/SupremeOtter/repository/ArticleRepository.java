package com.Cyanurzz.SupremeOtter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Cyanurzz.SupremeOtter.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
