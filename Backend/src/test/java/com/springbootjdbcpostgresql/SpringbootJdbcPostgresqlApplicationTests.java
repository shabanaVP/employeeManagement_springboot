package com.springbootjdbcpostgresql;

import com.springbootjdbcpostgresql.model.Employee;
import com.springbootjdbcpostgresql.repository.EmployeRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SpringbootJdbcPostgresqlApplicationTests {

	@Autowired
	EmployeRepository eRepo;


	@Test
	@Order(1)
	public void testCreate(){
        Employee e = new Employee();
		e.setFname("ansil");
        e.setLname("ndiya");
    	e.setId(15);
		e.setTel("123456");
		e.setEmail("shabana@1912");
		e.setAddress("param");
		e.setCity("kolo");
		e.setState("ak");
		e.setZip(1234);

		eRepo.save(e);
		assertNotNull(eRepo.findById(15).getId());

	}

	@Test
	@Order(2)
	public void testReadAll(){
		List<Employee> list = eRepo.findAll();
		assertThat((list).size()).isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void testSingleEmployee(){
         Employee employee = eRepo.findById(15);
		 assertEquals(1234,employee.getZip());
	}



	@Test
	@Order(4)
	public void testUpdate(){
		Employee e = eRepo.findById(15);
		e.setZip(9999);
		eRepo.update(e);
		Employee updatedEmp =eRepo.findById(15);
		assertThat(updatedEmp.getZip()).isEqualTo(9999);
	}

	@Test
	@Order(5)
	public void testDelete(){
		Employee e = eRepo.findById(15);
		eRepo.deleteById(e.getId());
		Employee deleteEmp = eRepo.findById(15);
		assertThat(deleteEmp).isNull();
	}


}
