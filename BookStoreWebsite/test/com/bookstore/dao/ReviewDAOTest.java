package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Book;
import com.bookstore.entity.Customer;
import com.bookstore.entity.Review;

public class ReviewDAOTest {
	
	private static ReviewDAO reviewDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		reviewDao = new ReviewDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		reviewDao.close();
	}

	@Test
	public void testCreateReview() {
		Review review = new Review();
		
		Book book = new Book();
		book.setBookId(17);
		
		Customer customer = new Customer();
		customer.setCustomerId(2);
		
		review.setBook(book);
		review.setCustomer(customer);
		
		review.setHeadline("About book 2");
		review.setRating(3);
		review.setComment("This is good book");
		
		Review savedReview = reviewDao.create(review);
		
		assertTrue(savedReview.getReviewId() > 0);
	}

	@Test
	public void testGet() {
		Integer reviewId = 1;
		Review review = reviewDao.get(reviewId);
		
		assertNotNull(review);
	}
	
	@Test
	public void testUpdateReview() {
		Integer reviewId = 1;
		Review review = reviewDao.get(reviewId);
		
		review.setHeadline("Excellent book");
		review.setComment("This is excellent book!");
		
		Review updatedReview = reviewDao.update(review);
		
		assertEquals(review.getHeadline(), updatedReview.getHeadline());
	}
	
	@Test
	public void testDeleteReview() {
		int reviewId = 2;
		reviewDao.delete(2);
		
		Review review = reviewDao.get(reviewId);
		
		assertNull(review);
	}

	@Test
	public void testListAll() {
		List<Review> listReview = reviewDao.listAll(); 
		
		for (Review review : listReview) {
			System.out.println(review.getReviewId() 
					+ " - " + review.getBook().getTitle() 
					+ " - " + review.getCustomer().getFullName()
					+ " - " + review.getHeadline() 
					+ " - " + review.getRating());
		}
		
		assertTrue(listReview.size() > 0);
	}

	@Test
	public void testCount() {
		Long totalReview = reviewDao.count();
		System.out.println("Total review: " + totalReview);
		
		assert(totalReview > 0 );
	}
	
	@Test
	public void testFindByCustomerAndBookNotFound() {
		Integer customerId = 100;
		Integer bookId=99;
		
		Review result = reviewDao.findByCustomerAndBook(customerId, bookId);
		
		assertNull(result);
	}
	
	@Test
	public void testFindByCustomerAndBookFound() {
		Integer customerId = 4;
		Integer bookId=4;
		
		Review result = reviewDao.findByCustomerAndBook(customerId, bookId);
		
		assertNotNull(result);
	}
	
	@Test
	public void testListMostRecent() {
		List<Review> recentReview = reviewDao.listMostRecent();
		
		assertEquals(3, recentReview.size());
	}

}
