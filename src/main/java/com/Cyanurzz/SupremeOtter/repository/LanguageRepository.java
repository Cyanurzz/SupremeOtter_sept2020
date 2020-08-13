package com.Cyanurzz.SupremeOtter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Cyanurzz.SupremeOtter.entity.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {

	Language findByKeyAndLocale(String key, String locale);
}
