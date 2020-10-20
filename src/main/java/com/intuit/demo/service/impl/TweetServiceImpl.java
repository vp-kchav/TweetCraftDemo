package com.intuit.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.intuit.demo.dao.impl.TweetDaoImpl;
import com.intuit.demo.model.Tweet;
import com.intuit.demo.pattern.mediator.TweetMediator;
import com.intuit.demo.pattern.observer.EmployeeTweet;
import com.intuit.demo.pattern.observer.EmailNotificationObserver;
import com.intuit.demo.service.TweetService;

@Component
public class TweetServiceImpl implements TweetService{

//	@Autowired
//	private TweetRepository tweetRepository;
	private static final Logger logger = LoggerFactory.getLogger(TweetServiceImpl.class);
	
	@Value("${employee.max.tweet.number}")
	private int maxTweetNumberMax;
	
	@Autowired 
	private TweetMediator tweetMediator;
	
	@Autowired
	private TweetDaoImpl tweetDao;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean tweetMessage(final Tweet tweet) {
		//call tweetReposition to add data to DB
		//tweetRepository.save(tweet);
		boolean result = false;
		if(tweet.getTweetFrom().getNumberOfTweet() <=maxTweetNumberMax) {
			result = tweetDao.addTweet(tweet);
			tweetMediator.registerTweet(tweet);
			EmployeeTweet employeeTweet = new EmployeeTweet(tweetMediator);
			employeeTweet.setTweet(tweet);
			new EmailNotificationObserver(employeeTweet);
			result = employeeTweet.tweet();
		} else {
			logger.warn("You have reached the max number of tweet today");
			result = false;
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean addTweet(Tweet tweet)  {
		return tweetDao.addTweet(tweet);
	}
}
