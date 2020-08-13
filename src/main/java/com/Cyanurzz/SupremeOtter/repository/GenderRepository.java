package com.Cyanurzz.SupremeOtter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Cyanurzz.SupremeOtter.entity.contentGame.Gender;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Integer> {

}
