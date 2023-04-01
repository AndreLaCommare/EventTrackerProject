package com.skilldistillery.tracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.tracker.entities.Member;
import com.skilldistillery.tracker.services.MemberService;

@RestController
@RequestMapping("rest")
public class MemberController {

	@Autowired
	MemberService memberServ;
	
	@GetMapping("members")
	List<Member> findAllMembers(){
		return memberServ.findAll();
	}
}
