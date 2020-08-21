package com.Cyanurzz.SupremeOtter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Cyanurzz.SupremeOtter.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
