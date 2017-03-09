package com.test.repository;

import org.junit.BeforeClass;
import org.junit.Test;

import com.boot.entity.Users;
import com.boot.repository.UserRepository;
import com.boot.repository.impl.UserRepositoryImpl;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;


public class UserRepositoryTest {

	private static UserRepository userRepository = null;
	private static Users user1 = null;
	private static Users user2 = null;

	@BeforeClass
	public static void setUp() {
		userRepository = mock(UserRepositoryImpl.class);
		user1 = new Users();
		user1.setUserId(1);
		user1.setSurname("Surname");
		user1.setEmail("email@gmail.com");
		user1.setPhone("1234567890");
		user1.setPassword("password");
		user1.setLogin("login");
		
		user2 = new Users();
		user2.setUserId(2);
		user2.setSurname("Surname2");
		user2.setPhone("1111111111");
		user2.setLogin("mylogin");
		when(userRepository.findByLogin("mylogin")).thenReturn(user2);
		when(userRepository.findByLoginAndPassword("login", "password")).thenReturn(user1);
	}
	
	@Test
	public void testFindByLogin(){
		Users user = userRepository.findByLogin(user2.getLogin());
		assertNotNull(user);
		assertEquals(new Integer(2), user.getUserId());
	}
	
	@Test
	public void testFindByLoginAndPassword(){
		Users user = userRepository.findByLoginAndPassword(user1.getLogin(), user1.getPassword());
		assertNotNull(user);
		assertEquals("Surname", user.getSurname());
	}
	
}