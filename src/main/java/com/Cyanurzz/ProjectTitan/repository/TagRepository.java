package com.Cyanurzz.ProjectTitan.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.Cyanurzz.ProjectTitan.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {
	
	Tag findByName( String tag);
}
