package com.skilldistillery.tracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	List<Gym> findAllGyms() {
		return gymServ.findAll();
	}

	@GetMapping("gyms/{gymId}")
	Gym findGymById(@PathVariable Integer gymId, HttpServletResponse res) {
		System.out.println("In Controller gym Id =" + gymId);
		if (gymServ.getById(gymId) == null) {
			System.out.println("Shouldnt arrive here");
			res.setStatus(404);
		}

		Gym gym = gymServ.getById(gymId);
		System.out.println(gym);
		return gym;
	}

	@PostMapping("gyms")
	public Gym newGym(@RequestBody Gym gym, HttpServletResponse res, HttpServletRequest req) {
		gym = gymServ.createGym(gym);
		try {
			if (gym == null) {
				res.setStatus(404);
			} else {
				res.setStatus(201);
				res.setHeader("Location", req.getRequestURL().append("/").append(gym.getId()).toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gym;

	}

	@DeleteMapping("gyms/{gymId}")
	public void removePostComment(@PathVariable Integer gymId, HttpServletResponse res) {
		try {
			if (gymServ.deleteGymById(gymId)) {
				
				res.setStatus(204);
			} else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
	}

}
