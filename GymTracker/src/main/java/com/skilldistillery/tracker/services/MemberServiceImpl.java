package com.skilldistillery.tracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.tracker.entities.Member;
import com.skilldistillery.tracker.repositories.MemberRepository;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberRepository memberRepo;
	@Override
	public List<Member> findAll() {
		// TODO Auto-generated method stub
		return memberRepo.findAll();
	}

}
