package com.skilldistillery.tracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.tracker.entities.Gym;
import com.skilldistillery.tracker.repositories.GymRepository;
@Service
public class GymServiceImpl implements GymService {
	
	@Autowired
	GymRepository gymRepo;

	@Override
	public List<Gym> findAll() {
		// TODO Auto-generated method stub
		return gymRepo.findAll();
	}

}