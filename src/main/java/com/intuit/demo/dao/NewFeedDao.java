package com.intuit.demo.dao;

import java.util.List;

import com.intuit.demo.model.EmployeeNewFeed;

/**
 * 
 * @author kchav
 *
 */
public interface NewFeedDao {

	/**
	 * Add newFeed
	 * @param newFeed
	 * @return
	 */
	public boolean addNewFeed(EmployeeNewFeed newFeed); 
	
	/**
	 * 
	 * @return
	 */
	public List<EmployeeNewFeed> getAll();
	
	/**
	 * 
	 * @param topNumber
	 * @return
	 */
	public List<EmployeeNewFeed> getTopNumberFeedById(int topNumber,Long id);

}
