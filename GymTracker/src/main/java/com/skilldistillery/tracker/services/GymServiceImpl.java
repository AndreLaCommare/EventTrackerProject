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

	@Override
	public boolean deleteGymById(int gymId) {
		// TODO Auto-generated method stub
		boolean deleted = false;
		Gym gym = gymRepo.queryById(gymId);
		if (gym != null) {
			gymRepo.delete(gym);
			deleted = true;
		}
		
		return deleted;
	}

	@Override
	public Gym updateGym(Gym gym, int gymId) {
		// TODO Auto-generated method stub
		Gym managedGym = gymRepo.queryById(gymId);
		if (managedGym != null) {
			managedGym.setAddress(gym.getAddress());
			managedGym.setPhoneNumber(gym.getPhoneNumber());
			managedGym.setName(gym.getName());
			managedGym.setState(gym.getState());
			managedGym.setCity(gym.getCity());
		}
		gymRepo.saveAndFlush(managedGym);
		return managedGym;
	}
}
