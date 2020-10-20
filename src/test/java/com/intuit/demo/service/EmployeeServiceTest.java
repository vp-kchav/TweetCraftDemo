/**
 * Created March 18,2018
 */
package com.intuit.demo.service;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.intuit.demo.model.Employee;

/**
 * @author kimtey
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

	@Autowired
	private EmployeeService employeeService;

	
	@Before
	public void setUp() throws Exception {

	}
	
	@After
	public void tearDown() throws Exception {
	    
	}

	@Test
	public void testGetById() {
		Employee employee = employeeService.findEmployeeById(1l);
		assertTrue(employee !=null);
	}
	
	@Test
	public void testGetByIds() {
		List<Long> ids = new ArrayList<Long>();
		ids.add(1l);ids.add(2l);
		List<Employee> employees = employeeService.findEmployeesByIds(ids);
		assertTrue(employees.size() ==2);
	}
	
	@Test
	public void testGetByIdNegetive() {
		Employee employee = employeeService.findEmployeeById(12222l);
		assertTrue(employee ==null);
	}
	
	@Test
	public void testGetByIdsNegative() {
		List<Long> ids = new ArrayList<Long>();
		ids.add(11232l);ids.add(23232l);
		List<Employee> employees = employeeService.findEmployeesByIds(ids);
		assertTrue(employees.size() ==0);
	}
	
}
