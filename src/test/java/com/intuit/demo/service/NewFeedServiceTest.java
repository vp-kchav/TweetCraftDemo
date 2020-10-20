/**
 * Created March 18,2018
 */
package com.intuit.demo.service;

import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.intuit.demo.model.Employee;
import com.intuit.demo.model.EmployeeNewFeed;
import com.intuit.demo.service.impl.EmployeeServiceImpl;
import com.intuit.demo.utils.ApplicationConstants;
import com.intuit.demo.utils.DateTimeUtils;

/**
 * @author kimtey
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NewFeedServiceTest {

	@Autowired
	private NewFeedService newFeedService;

	
	@Before
	public void setUp() throws Exception {

	}
	
	@After
	public void tearDown() throws Exception {
	    
	}

	@Test
	public void testAddNewFeed() {
		EmployeeNewFeed newFeed = new EmployeeNewFeed();
		newFeed.setEmployeeId(1002l);
		newFeed.setNewFeedId(1l);
		newFeed.setMessage("Test case 1");
		newFeed.setTweetDate(new Date());
		
		boolean result = newFeedService.addNewFeed(newFeed);
		assertTrue(result);
	}
	
	@Test
	public void testGetNewFeed() {
		List<EmployeeNewFeed> result = newFeedService.getTopNumberFeed(2, 3l);
		assertTrue(result.size()==2);
	}
	
}
