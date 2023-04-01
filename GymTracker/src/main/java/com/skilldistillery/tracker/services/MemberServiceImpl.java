package com.skilldistillery.tracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.tracker.entities.Gym;
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
	@Override
	public Member createMember(Member member, int gymId) {
		// TODO Auto-generated method stub
		Gym gym = new Gym();
		gym.setId(gymId);
		member.setGym(gym);
		return memberRepo.saveAndFlush(member);
	}
	
	@Override
	public Member getById(int memberId) {
		// TODO Auto-generated method stub
		Optional<Member> opt= memberRepo.findById(memberId);
		if (opt != null) {
			return opt.get();
		}
		return null;
		
	}

}
