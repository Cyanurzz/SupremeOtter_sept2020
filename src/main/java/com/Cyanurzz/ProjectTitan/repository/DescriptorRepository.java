package com.Cyanurzz.ProjectTitan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Cyanurzz.ProjectTitan.entity.contentGame.Descriptor;

@Repository
public interface DescriptorRepository extends JpaRepository<Descriptor, Integer> {

}
