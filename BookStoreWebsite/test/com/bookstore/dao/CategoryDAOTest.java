package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Category;
import com.bookstore.entity.Users;

public class CategoryDAOTest {
		
	private static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		categoryDAO = new CategoryDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		categoryDAO.close();
	}

	@Test
	public void testCreateCategory() {
		Category newCat = new Category("Politics");
		Category category = categoryDAO.create(newCat);
		
		assertTrue(category != null && category.getCategoryId() > 0);
	}

	@Test
	public void testUpdateCategory() {
		Category cat = new Category("Java Core");
		cat.setCategoryId(1);
		
		Category category = categoryDAO.update(cat);
		
		assertEquals(cat.getName(), category.getName());
	}

	@Test
	public void testGet() {
		Integer catId = 3;
		Category cat = categoryDAO.get(catId);
		
		assertNotNull(cat);
	}

	@Test
	public void testDeleteCategory() {
		Integer catId=15;
		categoryDAO.delete(catId);
		
		Category cat = categoryDAO.get(catId);
		assertNull(cat);
	}

	@Test
	public void testListAll() {
		List<Category> listCategory = categoryDAO.listAll();
		
		//listCategory.forEach(c -> System.out.println(c.getName() + ", "));
		for (Category category : listCategory) {
			System.out.println(category.getName());
		}
		
		
		assertTrue(listCategory.size() > 0);
	}

	@Test
	public void testCount() {
		long totalCategory = categoryDAO.count();
		
		assertEquals(7, totalCategory);
	}
	
	@Test
	public void testFindByName() {
		String name = "Java Core ";
		Category category = categoryDAO.findByName(name);
		
		assertNotNull(category);
	}
	
	@Test
	public void testFindByNameNotFound() {
		String name = "Java Core 1";
		Category category = categoryDAO.findByName(name);
		
		assertNull(category);
	}

}
