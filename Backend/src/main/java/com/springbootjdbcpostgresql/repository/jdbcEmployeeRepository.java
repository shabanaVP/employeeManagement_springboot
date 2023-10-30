package com.springbootjdbcpostgresql.repository;

import com.springbootjdbcpostgresql.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@Repository
public class jdbcEmployeeRepository implements EmployeRepository {


	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Employee> findAll() {
		return jdbcTemplate.query("SELECT * from mytable", BeanPropertyRowMapper.newInstance(Employee.class));
	}


	@Override
	public Employee findById(int id) {
		try {
			Employee tutorial = jdbcTemplate.queryForObject("SELECT * FROM mytable WHERE id=?",
					BeanPropertyRowMapper.newInstance(Employee.class), id);
			return tutorial;
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	@Override
	public int save(Employee employee) {
		List<Employee> obj = jdbcTemplate.query("SELECT * from mytable", BeanPropertyRowMapper.newInstance(Employee.class));

		int x = obj.size()+1;
		System.out.println(x);
		return jdbcTemplate.update("INSERT INTO mytable ( fname, lname,id, tel,  email,address, city,state, zip) VALUES(?,?,?,?,?,?,?,?,?)",
				new Object[]{employee.getFname(), employee.getLname(), x, employee.getTel(), employee.getEmail(), employee.getAddress(), employee.getCity(), employee.getState(), employee.getZip()});
	}

	@Override
	public int deleteById(int id) {
		return jdbcTemplate.update("DELETE FROM mytable WHERE id=?", id);
	}

	@Override
	public int update(Employee tutorial) {
		return jdbcTemplate.update("UPDATE mytable SET fname=?, lname=?, tel=?, email=?, address=?, city=?, state=?,zip=? WHERE id=?",
				new Object[] { tutorial.getFname(), tutorial.getLname(), tutorial.getTel(), tutorial.getEmail(), tutorial.getAddress(),tutorial.getCity(), tutorial.getState(), tutorial.getZip(), tutorial.getId()});
	}


}
