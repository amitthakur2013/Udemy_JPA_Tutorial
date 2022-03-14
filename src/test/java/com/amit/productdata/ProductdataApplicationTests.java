package com.amit.productdata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
class ProductdataApplicationTests {

	@Autowired
	ProductRepository productRepository;

	/*
	 * @Test
	 * 
	 * @Order(1) void contextLoads() { }
	 * 
	 * @Test
	 * 
	 * @Order(2) public void testCreate() { Product product = new Product();
	 * product.setId(1); product.setName("IPhone"); product.setDesc("Awesome");
	 * product.setPrice(1000d);
	 * 
	 * productRepository.save(product);
	 * 
	 * }
	 * 
	 * @Test
	 * 
	 * @Order(3) public void testRead() { Optional<Product> findById =
	 * productRepository.findById(1); assertNotNull(findById); assertEquals(1,
	 * findById.get().getId()); }
	 * 
	 * @Test
	 * 
	 * @Order(4) public void testUpdate() { Product product =
	 * productRepository.findById(1).get(); product.setPrice(2000d);
	 * productRepository.save(product); }
	 * 
	 * @Test
	 * 
	 * @Order(5) public void testDelete() { if (productRepository.existsById(999))
	 * productRepository.deleteById(1); }
	 * 
	 * @Test
	 * 
	 * @Order(6) public void testFindByName() { List<Product> products =
	 * productRepository.findByName("Washer"); products.forEach( p ->
	 * System.out.println(p.getPrice())); }
	 * 
	 * @Test
	 * 
	 * @Order(7) public void testFindByNameAndDesc() { List<Product> products =
	 * productRepository.findByNameAndDesc("Washer","Awesome"); products.forEach( p
	 * -> System.out.println(p.getPrice())); }
	 * 
	 * @Test
	 * 
	 * @Order(7) public void testFindByPriceGreater() { List<Product> products =
	 * productRepository.findByPriceGreaterThan(500d); products.forEach( p ->
	 * System.out.println(p.getPrice())); }
	 */

	@Test
	public void testfindAllPaging() {
		Pageable pageable = PageRequest.of(0, 2);
		Page<Product> results = productRepository.findAll(pageable);
		results.forEach(p -> System.out.println(p.getName()));
	}
	
	@Test
	public void testfindAllSorting() {
//		productRepository.findAll(Sort.by(Direction.ASC, "price"))
//		.forEach(p -> System.out.println(p.getPrice()));
		
		// Multiple sort orders
		List<Order> orders = new ArrayList<Sort.Order>();
		
		Order o1 = new Order(Direction.DESC, "price");
		Order o2 = new Order(Direction.ASC,"name");
		
		orders.add(o1);
		orders.add(o2);
		productRepository.findAll(Sort.by(orders))
		.forEach(p -> System.out.println(p.getName()));
		
		
	}
	
	@Test
	public void testfindAllPagingAndSorting() {
		Pageable pageable=PageRequest.of(0, 2,Direction.DESC,"name");
		productRepository.findAll(pageable).forEach(p -> System.out.println(p.getName()));
	}

}
