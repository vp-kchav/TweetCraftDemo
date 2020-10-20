package com.intuit.demo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intuit.demo.dao.impl.EmployeeDaoImpl;
import com.intuit.demo.model.Employee;
import com.intuit.demo.service.EmployeeService;

@Component
public class EmployeeServiceImpl implements EmployeeService{
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	EmployeeDaoImpl employeeDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Employee findEmployeeById(Long id) {
		logger.info("Getting Employee by ID = \""+ id +"\"");
		return employeeDao.findEmployeeById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Employee> findEmployeesByIds(List<Long> ids) {
		logger.info("Getting Employees by IDs = \""+ ids.toString() +"\"");
		return employeeDao.findEmployeesByIds(ids);
	}

}
