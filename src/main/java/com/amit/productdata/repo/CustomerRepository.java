package com.amit.productdata.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amit.productdata.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	List<Customer> findByNameAndEmail(String name, String email);
	List<Customer> findByEmailLike(String email);
	List<Customer> findByIdIn(List<Integer> ids);
}
