package com.skilldistillery.tracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping(path="gyms/{gymId}/members")
	public Member create(@PathVariable Integer gymId, @RequestBody Member member, HttpServletResponse res,HttpServletRequest req) {
		
		try {
			member = memberServ.createMember(member, gymId);
			res.setStatus(201);
			StringBuffer url = req.getRequestURL();
			url.append("/").append(member.getId());
			res.setHeader("Location", url.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res.setStatus(400);
			member = null;
		}
		
		
		return member;
	}
}
