package com.skilldistillery.tracker.services;

import java.util.List;

import com.skilldistillery.tracker.entities.Gym;

public interface GymService {

	List<Gym> findAll();
}