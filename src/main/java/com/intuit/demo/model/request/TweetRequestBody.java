package com.intuit.demo.model.request;

import java.util.List;

public class TweetRequestBody {
	
	private Long tweetId;
	private Long tweetFrom;
	private List<Long> tweetTo;
	private String message;
	public Long getTweetId() {
		return tweetId;
	}
	public void setTweetId(Long tweetId) {
		this.tweetId = tweetId;
	}
	public Long getTweetFrom() {
		return tweetFrom;
	}
	public void setTweetFrom(Long tweetFrom) {
		this.tweetFrom = tweetFrom;
	}
	public List<Long> getTweetTo() {
		return tweetTo;
	}
	public void setTweetTo(List<Long> tweetTo) {
		this.tweetTo = tweetTo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
