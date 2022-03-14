package com.amit.productdata.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amit.productdata.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	List<Customer> findByNameAndEmail(String name, String email);
	List<Customer> findByEmailLike(String email);
	List<Customer> findByIdIn(List<Integer> ids, Pageable pageable);
	
	@Modifying
	@Query("update Customer set email=:email where id=:id")
	void updateCustomerEmail(@Param("id")int id,@Param("email") String email);
}
