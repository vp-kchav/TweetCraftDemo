package com.intuit.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intuit.demo.dao.impl.NewFeedDaoImpl;
import com.intuit.demo.model.EmployeeNewFeed;
import com.intuit.demo.service.NewFeedService;

@Component
public class NewFeedServiceImpl implements NewFeedService {

//	@Autowired
//	NewFeedRepository newFeedRepository;
	
	@Autowired
	NewFeedDaoImpl newFeedDao;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addNewFeed(EmployeeNewFeed newFeed) {
		//call newFeedRepository to add data to DB
		//newFeedRepository.save(newFeed);
	
		return newFeedDao.addNewFeed(newFeed);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<EmployeeNewFeed> getAll() {
		return newFeedDao.getAll();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<EmployeeNewFeed> getTopNumberFeed(int topNumber,Long id) {
		return newFeedDao.getTopNumberFeedById(topNumber,id);
	}
}
