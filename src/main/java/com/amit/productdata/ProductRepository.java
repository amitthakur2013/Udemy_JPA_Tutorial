package com.amit.productdata;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer>{

	List<Product> findByName(String name);
	
	List<Product> findByNameAndDesc(String name, String desc);
	
	List<Product> findByPriceGreaterThan(double price);
	
	List<Product> findByDescContains(String text);
	
	List<Product> findByPriceBetween(double p1, double p2);
	
	List<Product> findByDescLike(String like);
	
	List<Product> findByIdIn(List<Long> ids);
}
