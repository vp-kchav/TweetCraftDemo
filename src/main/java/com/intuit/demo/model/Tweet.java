/**
 * created January, 26, 2019
 */
package com.intuit.demo.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * 
 * @author kchav
 *
 */
public class Tweet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long tweetId;
	private Employee tweetFrom;
	private Collection<Employee> tweetTo;
	private String message;
	private Date tweetDateTime;
	
	public Long getTweetId() {
		return tweetId;
	}
	public void setTweetId(Long tweetId) {
		this.tweetId = tweetId;
	}
	public Employee getTweetFrom() {
		return tweetFrom;
	}
	public void setTweetFrom(Employee tweetFrom) {
		this.tweetFrom = tweetFrom;
	}
	public Collection<Employee> getTweetTo() {
		return tweetTo;
	}
	public void setTweetTo(Collection<Employee> tweetTo) {
		this.tweetTo = tweetTo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTweetDateTime() {
		return tweetDateTime;
	}
	public void setTweetDateTime(Date tweetDateTime) {
		this.tweetDateTime = tweetDateTime;
	}

}
