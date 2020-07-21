package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Customer;

public class CustomerDAOTest {

	private static CustomerDAO customerDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		customerDao = new CustomerDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		customerDao.close();
	}

	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setEmail("customer3@gmail.com");
		customer.setFullName("Customer3");
		customer.setCity("Beograd");
		customer.setCountry("Serbia");
		customer.setAddress("Cirila i Metodija");
		customer.setPassword("customer3");
		customer.setPhone("123456");
		customer.setZipcode("11000");
		
		Customer savedCustomer = customerDao.create(customer);
		
		assertTrue(savedCustomer.getCustomerId() > 0);
	}

	@Test
	public void testGet() {
		Integer customerId = 1;
		Customer customer = customerDao.get(customerId);
		
		assertNotNull(customer);
	}
	
	@Test
	public void testUpdateCustomer() {
		Customer customer = customerDao.get(1);
		String fullName = "customer1 updated";
		customer.setFullName(fullName);
		
		Customer updatedCustomer = customerDao.update(customer);
		
		assertTrue(updatedCustomer.getFullName().equals(fullName));
	}

	@Test
	public void testDeleteCustomer() {
		Integer customerId = 1;	
		customerDao.delete(customerId);
		Customer customer = customerDao.get(1);
		
		assertNull(customer);
	}
	
	@Test
	public void testListAll() {
		List<Customer> listCustomers = customerDao.listAll();
		
		for (Customer customer : listCustomers) {
			System.out.println(customer.getFullName());
		} 
		
		assertFalse(listCustomers.isEmpty());
	}
	
	@Test
	public void testFindByEmail() {
		String email = "customer3@gmail.com";
		Customer customer = customerDao.findByEmail(email);
		
		assertNotNull(customer);
	}
	
	@Test
	public void testCount() {
		long totalCustomer = customerDao.count();
		
		assertEquals(3, totalCustomer);	
	}
	
	@Test 
	public void testCheckLoginSuccess() {
		String email = "customer1@gmail.com";
		String password = "customer1";
		
		Customer customer = customerDao.checkLogin(email, password);
		
		assertNotNull(customer);
	}
	
	@Test 
	public void testCheckLoginFail() {
		String email = "abc@gmail.com";
		String password = "customer1";
		
		Customer customer = customerDao.checkLogin(email, password);
		
		assertNull(customer);
	}
	
}
