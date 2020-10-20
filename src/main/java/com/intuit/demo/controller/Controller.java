package com.intuit.demo.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.DataTestBuilder;
import com.intuit.demo.datacenter.DataCenter;
import com.intuit.demo.model.Tweet;
import com.intuit.demo.service.EmployeeService;
import com.intuit.demo.service.impl.TweetServiceImpl;
import com.intuit.demo.utils.SetTransactionIdInMDC;

/**
 * 
 * @author kchav
 *
 */
@RestController
public class Controller {
	
	@Autowired
	DataCenter dataCenter;
	
	@Autowired
	TweetServiceImpl tweetService;
	
	@Autowired
	EmployeeService employeeService;
	
	private static final Logger logger = LoggerFactory.getLogger(Controller.class);

	@PostConstruct
	public void init() throws ParseException {
		dataCenter.setEmployees(DataTestBuilder.buildEmployeeData());
		tweetMessage();
	}
	
	/**
	 * tweet message for testing
	 */
	private void tweetMessage() {
		List<Long> tos = new ArrayList<Long>();
		tos.add(3l);tos.add(4l);
		Tweet tweet1 = createTweet("Hello 1rs time from 1", 1l, tos);
		tweetService.tweetMessage(tweet1);
		
		tos = new ArrayList<Long>();
		tos.add(5l);
		Tweet tweet2 = createTweet("Hello 2nd time time from 1", 1l, tos);
		tweetService.tweetMessage(tweet2);
		
		tos = new ArrayList<Long>();
		tos.add(3l);tos.add(4l);
		Tweet tweet3 = createTweet("Hello 3nd time time from 1", 1l, tos);
		tweetService.tweetMessage(tweet3);
		
		tos = new ArrayList<Long>();
		tos.add(5l);
		Tweet tweet4 = createTweet("Hello 4nd time time from 1", 1l, tos);
		tweetService.tweetMessage(tweet4);
		
		tos = new ArrayList<Long>();
		tos.add(3l);tos.add(4l);
		Tweet tweet5 = createTweet("Hello 1rs time from 2", 2l, tos);
		tweetService.tweetMessage(tweet5);
		
		tos = new ArrayList<Long>();
		tos.add(5l);
		Tweet tweet6 = createTweet("Hello 2nd time time from 2", 2l, tos);
		tweetService.tweetMessage(tweet6);
		
		tos = new ArrayList<Long>();
		tos.add(3l);tos.add(4l);
		Tweet tweet7 = createTweet("Hello 3nd time time from 2", 2l, tos);
		tweetService.tweetMessage(tweet7);
		
		tos = new ArrayList<Long>();
		tos.add(5l);
		Tweet tweet8 = createTweet("Hello 4nd time time from 2", 2l, tos);
		tweetService.tweetMessage(tweet8);
	}
	
	/**
	 * create object tweet
	 * @param message
	 * @param from
	 * @param to
	 * @return
	 */
	private Tweet createTweet(String message, Long from, List<Long> to) {
		Tweet tweet = new Tweet();
		tweet.setTweetId(Long.valueOf(dataCenter.getTweets().size() + 1));
		tweet.setTweetDateTime(new Date());
//		Employee empFrom = employeeService.findEmployeeById(1l);
		tweet.setTweetFrom(employeeService.findEmployeeById(from));
		tweet.setTweetTo(employeeService.findEmployeesByIds(to));
		tweet.setMessage(message);
		return tweet;
	}
	
	@GetMapping(value ="${path.helloworld}")
	public String index(@RequestHeader String intuit_tid) {
		
		SetTransactionIdInMDC.setMDC(intuit_tid);
		
		logger.info("this is a info message");
	    logger.warn("this is a warn message");
	    logger.error("this is a error message");
	    List<Long> ids  = new ArrayList<Long>();
	    ids.add(1l);
	    ids.add(2l);
	    System.out.println(dataCenter.findEmployeeById(3l));
	    
	    return dataCenter.findEmployeesByIds(ids) + " hello from me";
	}
	
}
