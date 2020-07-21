package com.bookstore.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.CustomerDAO;
import com.bookstore.entity.Customer;

public class CustomerServices {
	private CustomerDAO customerDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public CustomerServices(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.customerDAO = new CustomerDAO();
	}
	
	public void listCustomers () throws ServletException, IOException {
		listCustomers(null);
		//CustomerDAO customerDAO = new CustomerDAO();
		//List<Customer> listCustomer = customerDAO.listAll(); 
		
		
		//request.setAttribute("listCustomer", listCustomer);
		
		//String listPage = "customer_list.jsp";
		//RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		//requestDispatcher.forward(request, response);
	}
	
	public void listCustomers(String message) throws ServletException, IOException {
		CustomerDAO customerDAO = new CustomerDAO();
		List<Customer> listCustomer = customerDAO.listAll(); 
	
		if (message != null) {
			request.setAttribute("message", message);
		}
	
		request.setAttribute("listCustomer", listCustomer);
	
		String listPage = "customer_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}
	
	public void createCustomer() throws ServletException, IOException {
		CustomerDAO customerDAO = new CustomerDAO();
		String email = request.getParameter("email");
		Customer existCustomer = customerDAO.findByEmail(email);
		
		if (existCustomer != null) {
			String message = "Could not create new customer : the email "
					+ email + " is already registered by another customer." ;
			listCustomers(message);
			
		} else {
			Customer newCustomer = new Customer();
			updateCustomerFieldsFromFrom(newCustomer);	
			customerDAO.create(newCustomer);
			
			String message = "New customer has been created successfully.";
			listCustomers(message);
		}
	}
	
	private void updateCustomerFieldsFromFrom(Customer customer) {
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullName");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String city = request.getParameter("city");	
		String zipcode = request.getParameter("zipcode");
		String country = request.getParameter("country");
		
		if (email != null && !email.equals("")) {
			customer.setEmail(email);
		}
		
		customer.setFullName(fullName);
		
		if (password != null && !password.equals("")) {
			customer.setPassword(password);
		}
		
		customer.setPhone(phone); 
		customer.setAddress(address);
		customer.setCity(city);
		customer.setZipcode(zipcode);
		customer.setCountry(country);
	}

	public void registerCustomer() throws ServletException, IOException {
		CustomerDAO customerDAO = new CustomerDAO();
		String email = request.getParameter("email");
		Customer existCustomer = customerDAO.findByEmail(email);
		String message= "";
		
		if (existCustomer != null) {
			message = "Could not register. The email "
					+ email + " is already registered by another customer." ;
			
		} else {
			
			Customer newCustomer = new Customer();
			updateCustomerFieldsFromFrom(newCustomer);
			customerDAO.create(newCustomer);
			
			message = "You have registered successfully! <br/>"
					+ "<a href='Login'>Click here</a> to login";
		}
		
		String messagePage = "frontend/message.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(messagePage);
		request.setAttribute("message", message);
		requestDispatcher.forward(request, response);
	}
	
	public void editCustomer() throws ServletException, IOException {
		CustomerDAO customerDAO = new CustomerDAO();
		Integer customerId = Integer.parseInt(request.getParameter("id"));
		Customer customer = customerDAO.get(customerId);
		
		request.setAttribute("customer", customer);
		
		String editPage = "customer_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
	}

	public void updateCustomer() throws ServletException, IOException {
		CustomerDAO customerDAO = new CustomerDAO();
		Integer customerId = Integer.parseInt(request.getParameter("customerId"));
		String email = request.getParameter("email");
		
		Customer customerByEmail = customerDAO.findByEmail(email);
		String message = null;
		
		if ( customerByEmail != null && customerByEmail.getCustomerId() != customerId) {
			message = "Could not update the customer ID " + customerId 
					+ " becouse there is an existing customer with same email.";
			
		} else {
		
			Customer customerById = customerDAO.get(customerId);
			updateCustomerFieldsFromFrom(customerById);
			
			customerDAO.update(customerById);
			
			message = "The custome has been updated successfully.";
		}
		
		listCustomers(message);
		
	}

	public void deleteCustomer() throws ServletException, IOException {
		CustomerDAO customerDAO = new CustomerDAO();
		Integer customerId = Integer.parseInt(request.getParameter("id"));
		customerDAO.delete(customerId);

		String message = "The customer has been deleted successfully.";
		listCustomers(message);
	}

	public void showLogin() throws ServletException, IOException {
		String loginPage = "frontend/login.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(loginPage);
		dispatcher.forward(request, response);
	}

	public void doLogin() throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Customer customer =	customerDAO.checkLogin(email, password);
		
		if (customer == null) {
			String message = "Login failed. Please check your email and password.";
			request.setAttribute("message", message);
			showLogin();
			
		} else {
			request.getSession().setAttribute("loggedCustomer", customer);
			
			showCustomerProfile();
		}
	}
	
	public void showCustomerProfile() throws ServletException, IOException {
		String profilePage = "frontend/customer_profile.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(profilePage);
		dispatcher.forward(request, response);
	}

	public void showCustomerProfileEditForm() throws ServletException, IOException {
		String editPage = "frontend/edit_profile.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
		dispatcher.forward(request, response);
	}

	public void updateCustomerProfile() throws ServletException, IOException {
		Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");
		updateCustomerFieldsFromFrom(customer);
		customerDAO.update(customer);
		
		showCustomerProfile();
	}
	
}
