package com.amit.productdata;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.amit.productdata.model.Employee;
import com.amit.productdata.repo.EmployeeRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
class EmpTest {

	@Autowired
	EmployeeRepository repository;

	@Test
	@Order(1)
	void contextLoads() {
	}

	@Test
	@Order(2)
	public void testCreate() {
		Employee e = new Employee();
		e.setName("Amir");
		repository.save(e);
	}

}
