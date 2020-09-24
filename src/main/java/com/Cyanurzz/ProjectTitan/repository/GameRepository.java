package com.Cyanurzz.ProjectTitan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Cyanurzz.ProjectTitan.entity.Game;


@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

	@Query("SELECT g FROM Game g JOIN g.tags t WHERE t = LOWER(:tag)")
	List<Game> retrieveByTag(@Param("tag") String tag);
	
	@Query("SELECT g FROM  Game g WHERE g.mainGame = true")
	List<Game> retrieveMainGame();
	
}
