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

class GymTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Gym gym;
	

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
		gym = em.find(Gym.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		gym = null;
	}

	@Test
	void test() {
		assertNotNull(gym);
		assertEquals("AC4 Fitness", gym.getName());
		assertEquals("8051234567",gym.getPhoneNumber());
	}
	
	@Test
	void test_Gym_OneToMany_Member_mapping() {
		assertNotNull(gym);
		assertFalse(gym.getMembers().isEmpty());
	}

}
