package com.skilldistillery.tracker.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Member member;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAGymTracker");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		member = em.find(Member.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		member = null;
	}

	@Test
	void test() {
		assertNotNull(member);
		assertEquals("Andre La Commare", member.getName());
		assertEquals("8054569466",member.getPhoneNumber());
	}
	
	@Test 
	void test_Member_ManyToOne_Gym_mapping() {
		assertNotNull(member);
		assertEquals("AC4 Fitness", member.getGym().getName());
		
	}
}
