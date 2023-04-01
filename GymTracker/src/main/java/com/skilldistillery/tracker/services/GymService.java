package com.skilldistillery.tracker.services;

import java.util.List;

import com.skilldistillery.tracker.entities.Gym;

public interface GymService {

	List<Gym> findAll();
	Gym getById(int gymId);
	Gym createGym(Gym gym);
	boolean deleteGymById(int gymId);
	Gym updateGym(Gym gym, int gymId);
}
