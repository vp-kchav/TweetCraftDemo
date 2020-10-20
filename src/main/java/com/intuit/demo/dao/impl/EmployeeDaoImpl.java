package com.intuit.demo.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intuit.demo.dao.EmployeeDao;
import com.intuit.demo.datacenter.DataCenter;
import com.intuit.demo.model.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao{
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeDaoImpl.class);

	@Autowired
	DataCenter dataCenter;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Employee findEmployeeById(Long id) {
		logger.info("Getting Employee by ID = \""+ id +"\"");
		return dataCenter.findEmployeeById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Employee> findEmployeesByIds(List<Long> ids) {
		logger.info("Getting Employees by IDs = \""+ ids.toString() +"\"");
		return dataCenter.findEmployeesByIds(ids);
	}

}
