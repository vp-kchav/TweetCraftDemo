package com.intuit.demo.pattern.mediator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intuit.demo.model.Employee;
import com.intuit.demo.model.EmployeeNewFeed;
import com.intuit.demo.model.Tweet;
import com.intuit.demo.service.NewFeedService;

@Component
public class TweetMediator implements IMediator{

	private static final Logger logger = LoggerFactory.getLogger(TweetMediator.class);
	
	@Autowired
	private NewFeedService newFeedService;
	
	private Tweet tweet;
	
	public Tweet getTweet() {
		return tweet;
	}
	
	public void register(Tweet tweet) {
		this.tweet = tweet;
	}
	
	public void registerTweet(Tweet tweet){ 
		this.tweet = tweet;
	} 
	
	@Override
	public boolean tweet() {
		boolean result= false;
		logger.info("Mediator design pattern tweet the message= \"" +getTweet().getMessage() +"\"");
		for(Employee tweetTo: getTweet().getTweetTo()) {
			EmployeeNewFeed newFeed = new EmployeeNewFeed(getTweet().getMessage(), getTweet().getTweetDateTime());
			newFeed.setEmployeeId(tweetTo.getEmployeeID());
			newFeed.setNewFeedId(Long.valueOf(newFeedService.getAll().size() + 1));
			newFeed.setFrom(getTweet().getTweetFrom().getFirstName());
			result = newFeedService.addNewFeed(newFeed);
		}
		return result;
	}

}
