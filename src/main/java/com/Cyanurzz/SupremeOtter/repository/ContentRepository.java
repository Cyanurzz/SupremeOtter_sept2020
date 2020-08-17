package com.Cyanurzz.SupremeOtter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Cyanurzz.SupremeOtter.entity.Game;
import com.Cyanurzz.SupremeOtter.entity.contentGame.Content;

@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {
	
	List<Content> findByGame(Game game);
	
	Content findByKeyAndGameAndLocale(String key, Game game, String locale);

}
