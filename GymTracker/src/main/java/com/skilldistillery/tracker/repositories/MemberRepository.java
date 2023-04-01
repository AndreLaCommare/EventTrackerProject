package com.skilldistillery.tracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.tracker.entities.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	Member getById(int memberId);
}
