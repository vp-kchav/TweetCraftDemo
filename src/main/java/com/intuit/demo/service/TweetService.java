package com.intuit.demo.service;

import com.intuit.demo.model.Tweet;

public interface TweetService {

	/**
	 * Tweet Message Service 
	 * @param tweet
	 * @return
	 */
	boolean tweetMessage(Tweet tweet);
	
	/**
	 * 
	 * @param tweet
	 * @return
	 */
    boolean addTweet(Tweet tweet);
}
