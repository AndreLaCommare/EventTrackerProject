package com.skilldistillery.tracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.tracker.entities.Gym;
import com.skilldistillery.tracker.entities.Member;
import com.skilldistillery.tracker.repositories.GymRepository;
import com.skilldistillery.tracker.repositories.MemberRepository;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberRepository memberRepo;
	@Autowired
	GymRepository gymRepo;
	@Override
	public List<Member> findAll() {
		// TODO Auto-generated method stub
		return memberRepo.findAll();
	}
	@Override
	public Member createMember(Member member, int gymId) {
		// TODO Auto-generated method stub
		Gym gym = gymRepo.queryById(gymId);
		member.setGym(gym);
		System.out.println("***************************************************************************" + member);
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
	@Override
	public boolean deleteMemberById(int memberId) {
		// TODO Auto-generated method stub
		boolean deleted = false;
		Member member = memberRepo.getById(memberId);
		if (member != null) {
			memberRepo.delete(member);
			deleted = true;
		}
		
		return deleted;
	}
	@Override
	public Member updateMember(Member member, int memberId) {
		// TODO Auto-generated method stub
		Member managedMember = memberRepo.getById(memberId);
		if (managedMember != null) {
			managedMember.setName(member.getName());
			managedMember.setPhoneNumber(member.getPhoneNumber());
			managedMember.setGym(member.getGym());
		}
		
		memberRepo.saveAndFlush(managedMember);
		return managedMember;
	}

}
