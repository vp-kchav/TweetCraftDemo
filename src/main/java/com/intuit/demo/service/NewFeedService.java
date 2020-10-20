package com.intuit.demo.service;

import java.util.List;

import com.intuit.demo.model.EmployeeNewFeed;

public interface NewFeedService {

	/**
	 * 
	 * @param newFeed
	 * @return
	 */
	boolean addNewFeed(EmployeeNewFeed newFeed); 
	
	/**
	 * 
	 * @return
	 */
	List<EmployeeNewFeed> getAll();

	/**
	 * 
	 * @param topNumber
	 * @return
	 */
	public List<EmployeeNewFeed> getTopNumberFeed(int topNumber,Long id);

}
