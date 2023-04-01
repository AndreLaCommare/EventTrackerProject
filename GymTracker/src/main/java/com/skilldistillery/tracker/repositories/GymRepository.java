package com.skilldistillery.tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.tracker.entities.Gym;

public interface GymRepository extends JpaRepository<Gym, Integer> {
	
	Gym queryById(int gymId);
}
