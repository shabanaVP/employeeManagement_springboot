package com.springbootjdbcpostgresql;

import com.springbootjdbcpostgresql.model.Employee;
import com.springbootjdbcpostgresql.repository.EmployeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class negativeTest {

        @Autowired
        EmployeRepository eRepo;

        @Test
        public void testGetNamePositive() {
                Employee entry1 = new Employee("Susan Holmes", "122 Harringdale",15,"123456","abcedr","Workington", "CA14 2GH","ak",1234);
                assertEquals("Susan Holmes",entry1.getFname());
        }

        @Test
        public void testgetNameNegative(){
                Employee entry1 = new Employee("Susan Holmes", "122 Harringdale",15,"123456","abcedr","Workington", "CA14 2GH","ak",1234);
                assertFalse( entry1.getFname() == "Alison");
        }
        @Test
        public void testgetid(){
                Employee entry1 = new Employee("Susan Holmes", "122 Harringdale",15,"123456","abcedr","Workington", "CA14 2GH","ak",1234);
                assertFalse( entry1.getId() == 22);
        }

        








}
