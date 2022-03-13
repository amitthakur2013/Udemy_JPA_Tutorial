package com.amit.productdata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
class ProductdataApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	@Order(1)
	void contextLoads() {
	}

	@Test
	@Order(2)
	public void testCreate() {
		Product product = new Product();
		product.setId(1);
		product.setName("IPhone");
		product.setDesc("Awesome");
		product.setPrice(1000d);

		productRepository.save(product);

	}

	@Test
	@Order(3)
	public void testRead() {
		Optional<Product> findById = productRepository.findById(1);
		assertNotNull(findById);
		assertEquals(1, findById.get().getId());
	}

	@Test
	@Order(4)
	public void testUpdate() {
		Product product = productRepository.findById(1).get();
		product.setPrice(2000d);
		productRepository.save(product);
	}

	@Test
	@Order(5)
	public void testDelete() {
		if (productRepository.existsById(1))
			productRepository.deleteById(1);
	}

}
