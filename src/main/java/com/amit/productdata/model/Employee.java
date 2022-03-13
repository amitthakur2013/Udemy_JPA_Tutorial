package com.amit.productdata.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Employee {

	@GenericGenerator(name = "empid_generate",strategy = "com.amit.productdata.utility.CustomRandomIdGenerator")
	@GeneratedValue(generator = "empid_generate")
	//@TableGenerator(name = "employee_gen", table = "empid_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 100)
	@Id
	//@GeneratedValue(strategy = GenerationType.TABLE,generator = "employee_gen")
	private Long id;

	private String name;

	public Employee() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
