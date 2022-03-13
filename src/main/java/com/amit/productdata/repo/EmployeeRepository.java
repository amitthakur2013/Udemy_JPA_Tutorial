package com.amit.productdata.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amit.productdata.model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	
}
