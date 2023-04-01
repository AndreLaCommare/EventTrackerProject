package com.skilldistillery.tracker.services;

import java.util.List;

import com.skilldistillery.tracker.entities.Member;

public interface MemberService {
	List<Member> findAll();
}
