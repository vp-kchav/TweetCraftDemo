package com.intuit.demo.model;

import java.io.Serializable;
import java.util.Date;

public class EmployeeNewFeed implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long newFeedId;
	private Long employeeId;
	private String message;
	private Date tweetDate;
	private String from;
	

	public EmployeeNewFeed() {
		
	}
	
	
	public EmployeeNewFeed(String message, Date tweetDate) {
		this.message = message;
		this.tweetDate = tweetDate;
	}
	
	public String getFrom() {
		return from;
	}
	
	public void setFrom(String from) {
		this.from = from;
	}
	public Long getNewFeedId() {
		return newFeedId;
	}
	public void setNewFeedId(Long newFeedId) {
		this.newFeedId = newFeedId;
	}	
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTweetDate() {
		return tweetDate;
	}
	public void setTweetDate(Date tweetDate) {
		this.tweetDate = tweetDate;
	}
	
	@Override
	public String toString() {
		return "Tweet From " + employeeId + "; Message = " + message + " to " + from;
	}
	
}
