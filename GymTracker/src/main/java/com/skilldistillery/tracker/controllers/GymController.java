package com.skilldistillery.tracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}
