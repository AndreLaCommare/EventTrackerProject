package com.skilldistillery.tracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.tracker.entities.Member;
import com.skilldistillery.tracker.services.MemberService;

@CrossOrigin({ "*", "http://localhost/" })
@RestController
@RequestMapping("api")
public class MemberController {

	@Autowired
	MemberService memberServ;
	
	@GetMapping("members")
	List<Member> findAllMembers(){
		return memberServ.findAll();
	}
	@GetMapping("members/{memberId}")
	Member getById(@PathVariable Integer memberId, HttpServletResponse res){
		if(memberServ.getById(memberId)== null) {
			
			res.setStatus(404);
		}
		
		Member member = memberServ.getById(memberId);
		
		return member;
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
	
	@DeleteMapping("members/{memberId}")
	public void deleteMember(@PathVariable Integer memberId, HttpServletResponse res) {
		try {
			if (memberServ.deleteMemberById(memberId)) {
				
				res.setStatus(204);
			} else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
	}
	
	@PutMapping(path="members/{memberId}")
	public Member updateMember(@RequestBody Member member, @PathVariable Integer memberId, HttpServletResponse res,HttpServletRequest req) {
		Member updatedMember = memberServ.getById(memberId);
		try {
			updatedMember = memberServ.updateMember(member, memberId);
			if (updatedMember == null) {
				res.setStatus(404);
			}
			return updatedMember;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res.setStatus(400);
		}
		return updatedMember;
	}
}
