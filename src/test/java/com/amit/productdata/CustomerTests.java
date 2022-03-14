package com.amit.productdata;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Rollback;

import com.amit.productdata.model.Customer;
import com.amit.productdata.repo.CustomerRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
class CustomerTests {

	@Autowired
	CustomerRepository repository;

	@Test
	@Order(1)
	void contextLoads() {
	}

	@Test
	@Order(2)
	public void testCreate() {
		Customer c = new Customer();
		c.setEmail("test@test.test");
		c.setName("Ankur");
		repository.save(c);
	}
	
	@Test
	@Order(3)
	public void testfindByNameAndEmail() {
		List<Customer> c = repository.findByNameAndEmail("Ankur", "test@test.test");
		System.out.println(c);
	}
	
	@Test
	@Order(4)
	public void testfindByEmailLike() {
		List<Customer> c = repository.findByEmailLike("t%");
		System.out.println(c);
	}
	
	@Test
	@Order(4)
	public void testfindByIdIn() {
		List<Customer> c = repository.findByIdIn(Arrays.asList(1,3,4,5,6,7),PageRequest.of(2, 2,Sort.by(Direction.DESC,"id")));
		System.out.println(c);
	}
	
	@Test
	@Order(5)
	@Transactional
	@Rollback(false)
	public void testUpdateEmail() {
		repository.updateCustomerEmail(5, "ankur@gmail.com");
	}
	
	

}
