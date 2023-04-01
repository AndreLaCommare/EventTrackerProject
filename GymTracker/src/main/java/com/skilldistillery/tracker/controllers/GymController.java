package com.skilldistillery.tracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.tracker.entities.Gym;
import com.skilldistillery.tracker.services.GymService;

@RestController
@RequestMapping("rest")
public class GymController {

	@Autowired
	GymService gymServ;
	
	@GetMapping("gyms")
	List<Gym> findAllGyms(){
		return gymServ.findAll();
	}
	@GetMapping("gyms/{gymId}")
	Gym findGymById(@PathVariable Integer gymId, HttpServletResponse res){
		System.out.println("In Controller gym Id =" + gymId);
		if(gymServ.getById(gymId)== null) {
			System.out.println("Shouldnt arrive here");
			res.setStatus(404);
		}
		
		Gym gym = gymServ.getById(gymId);
		System.out.println(gym);
		return gym;
	}
	
}
