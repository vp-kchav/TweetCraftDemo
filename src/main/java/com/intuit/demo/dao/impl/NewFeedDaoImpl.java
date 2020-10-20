package com.intuit.demo.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intuit.demo.dao.NewFeedDao;
import com.intuit.demo.datacenter.DataCenter;
import com.intuit.demo.model.EmployeeNewFeed;

@Component
public class NewFeedDaoImpl implements NewFeedDao{
	
	private static final Logger logger = LoggerFactory.getLogger(NewFeedDaoImpl.class);
	
	@Autowired
	DataCenter dataCenter;
	
	/**
	 * {@inheritDoc}
	 * @param tweet
	 * @return
	 */
	@Override
	public boolean addNewFeed(EmployeeNewFeed newFeed)  {
		boolean result = true;
		try {
			logger.info("Add New NewFeed");
			dataCenter.addNewFeed(newFeed);
		}catch(Exception e) {
			logger.error("There is an error during add NewFeed, error =\"" +e.getStackTrace() +"\"" );
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<EmployeeNewFeed> getAll() {
		return dataCenter.getEmployeeNewFeeds();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<EmployeeNewFeed> getTopNumberFeedById(int topNumber, Long id) {
		return dataCenter.getNewFeedTopNumerById(topNumber, id);
	}

}
