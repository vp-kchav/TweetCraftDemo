package com.intuit.demo.service;

import java.util.List;

import com.intuit.demo.model.Employee;

public interface EmployeeService {

	/**
	 * 
	 * @param tweet
	 * @return
	 */
	public Employee findEmployeeById(Long id);
	
	/**
	 * 
	 * @param ids
	 * @return
	 */
	public List<Employee> findEmployeesByIds(List<Long> ids);
}