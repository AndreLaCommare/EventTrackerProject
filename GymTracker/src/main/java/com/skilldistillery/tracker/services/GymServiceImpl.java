package com.skilldistillery.tracker.services;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Gym getById(int gymId) {
		// TODO Auto-generated method stub
		Optional<Gym> opt= gymRepo.findById(gymId);
		if (opt != null) {
			return opt.get();
		}
		return null;
		
	}

	@Override
	public Gym createGym(Gym gym) {
		// TODO Auto-generated method stub
		if (gym!= null) {
		gymRepo.saveAndFlush(gym);
	}
		return gym;

}
}
