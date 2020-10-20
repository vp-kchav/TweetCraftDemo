/**
 * Created March 18,2018
 */
package com.intuit.demo.service;

import static org.junit.Assert.assertFalse;
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
import com.intuit.demo.model.Tweet;
import com.intuit.demo.service.impl.EmployeeServiceImpl;
import com.intuit.demo.utils.ApplicationConstants;
import com.intuit.demo.utils.DateTimeUtils;

/**
 * @author kimtey
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TweetServiceTest {

	Employee employeeFrom;
	List<Employee> employeesTo;
	
	@Autowired
	private TweetService tweetService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Before
	public void setUp() throws Exception {
		employeeFrom = employeeService.findEmployeeById(1l);
		List<Long> ids = new ArrayList<Long>();
		ids.add(2l);ids.add(3l);
		employeesTo = employeeService.findEmployeesByIds(ids);
	}
	
	@After
	public void tearDown() throws Exception {
	    
	}

	@Test
	public void testAddTweet() {
		Tweet tweet = new Tweet();
		tweet.setMessage("Test case 1");
		tweet.setTweetDateTime(new Date());
		tweet.setTweetFrom(employeeFrom);
		tweet.setTweetId(111l);
		tweet.setTweetTo(employeesTo);
		boolean result = tweetService.addTweet(tweet);
		assertTrue(result);
	}
	
	@Test
	public void testTweetMessage() {
		Tweet tweet = new Tweet();
		tweet.setMessage("Test case 1");
		tweet.setTweetDateTime(new Date());
		tweet.setTweetFrom(employeeFrom);
		tweet.setTweetId(111l);
		employeeFrom.setNumberOfTweet(10);
		tweet.setTweetTo(employeesTo);
		boolean result = tweetService.tweetMessage(tweet);
		assertTrue(result);
	}
	
	@Test
	public void testTweetMessageNegative() {
		Tweet tweet = new Tweet();
		tweet.setMessage("Test case 1");
		tweet.setTweetDateTime(new Date());
		tweet.setTweetFrom(employeeFrom);
		employeeFrom.setNumberOfTweet(20);
		tweet.setTweetId(111l);
		tweet.setTweetTo(employeesTo);
		boolean result = tweetService.tweetMessage(tweet);
		assertFalse(result);
	}
	
}
