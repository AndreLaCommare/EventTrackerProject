package com.skilldistillery.tracker.services;

import java.util.List;

import com.skilldistillery.tracker.entities.Member;

public interface MemberService {
	List<Member> findAll();
	Member createMember(Member member, int gymId);
	Member getById(int memberId);
	boolean deleteMemberById(int memberId);
	Member updateMember(Member member, int memberId);
}
