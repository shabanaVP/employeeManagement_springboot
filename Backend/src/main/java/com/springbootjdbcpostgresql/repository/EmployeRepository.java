package com.springbootjdbcpostgresql.repository;


import com.springbootjdbcpostgresql.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;






@Repository
public interface EmployeRepository {

	 List<Employee>findAll();
	Employee findById(int id);
	int save(Employee employee);
	int update(Employee employee);
	int deleteById(int id);



}
