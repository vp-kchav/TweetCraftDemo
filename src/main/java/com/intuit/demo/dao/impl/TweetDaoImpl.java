package com.intuit.demo.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.intuit.demo.dao.TweetDao;
import com.intuit.demo.datacenter.DataCenter;
import com.intuit.demo.model.Tweet;

@Component
public class TweetDaoImpl implements TweetDao{
	
	private static final Logger logger = LoggerFactory.getLogger(TweetDaoImpl.class);

	@Autowired
	DataCenter dataCenter;
	
	public boolean addTweet(Tweet tweet)  {
		boolean result = true;
		try {
			logger.info("Add new Tweet");
			dataCenter.addTweet(tweet);
		}catch(Exception e) {
			logger.error("There is an error during add Tweet, error =\"" +e.getStackTrace() +"\"" );
		}
		return result;
	}

}
