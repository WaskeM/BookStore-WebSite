package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Users;

public class UserDAOTest {
	
	private static UserDAO userDAO;
		
	@BeforeClass
	public static void setUpClass() throws Exception {
		userDAO = new UserDAO();
	}
	
	@AfterClass
	public static void tearDownClass() throws Exception {
		userDAO.close();
	}	

	@Test
	public void testCreateUsers() {
		Users user1 = new Users();
		user1.setEmail("test8@gmail.com");
		user1.setFullName("Tester8");
		user1.setPassword("test8");

		user1 = userDAO.create(user1);
		
		assertTrue(user1.getUserId() > 0);
	}
	
	@Test(expected = PersistenceException.class)
	public void testCreateUsersFieldsNotSet(){
		Users user1 = new Users();
		user1 = userDAO.create(user1);

	}
	
	@Test
	public void testUpdateUser() {
		Users user = new Users();
		user.setUserId(1);
		user.setEmail("waskem@gmail.com");
		user.setFullName("Marko Vasic");
		user.setPassword("v4ske.v");
		
		user = userDAO.update(user);
		String expected = "v4ske.v";
		String actual = user.getPassword();
		
		assertEquals(expected, actual);
	} 
	
	@Test
	public void testGetUsersFound() {
		Integer userId=5;
		Users user = userDAO.get(userId);	
		
		if(user!=null) {
			System.out.println(user.getEmail());
		}
		
		assertNotNull(user);
	}
	
	@Test 
	public void testGetUserNotFound() {
		
		Integer userId=99;
		Users user = userDAO.get(userId);	
		
		assertNull(user);
	}
	
	@Test
	public void testDeleteUsers() {
		Integer userId=6;
		userDAO.delete(userId);
		
		Users user = userDAO.get(userId);
		
		assertNull(user);
	}
	
	@Test (expected = EntityNotFoundException.class)
	public void testDeleteNonExistUsers() {
		Integer userId=555;
		userDAO.delete(userId);
	}
	
	@Test
	public void testListAll() {
		List<Users> listUsers = userDAO.listAll();
		
		for (Users user : listUsers) {
			System.out.println(user.getEmail());
		}
		
		assertTrue(listUsers.size()>0);
	}
	
	@Test
	public void testCount() {
		long totalUsers = userDAO.count();
		
		assertEquals(15, totalUsers);
	}
	
	@Test
	public  void testCheckLoginSuccess() {
		String email = "waskem@gmail.com";
		String password = "v4ske.v";
		boolean loginResult = userDAO.checkLogin(email, password);
		
		assertTrue(loginResult);
	}
	
	@Test
	public  void testCheckLoginFailed() {
		String email = "emaildontexist@gmail.com";
		String password = "v4ske.v";
		boolean loginResult = userDAO.checkLogin(email, password);
		
		assertFalse(loginResult);
	}
	
	@Test
	public void testFindByEmail() {
		String email="testA@gmail.com";
		Users user = userDAO.findByEmail(email);
		
		assertNotNull(user);
	}
	
	

}
