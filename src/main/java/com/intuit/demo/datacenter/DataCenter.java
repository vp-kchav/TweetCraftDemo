package com.intuit.demo.datacenter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.intuit.demo.model.Employee;
import com.intuit.demo.model.EmployeeNewFeed;
import com.intuit.demo.model.Tweet;

@Component
public class DataCenter {
	private List<Employee> employees = new ArrayList<Employee>();
	private List<Tweet> tweets = new ArrayList<Tweet>();
	private List<EmployeeNewFeed> employeeNewFeeds = new ArrayList<EmployeeNewFeed>();
	
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public List<Tweet> getTweets() {
		return tweets;
	}
	public void setTweets(List<Tweet> tweets) {
		this.tweets = tweets;
	}
	public List<EmployeeNewFeed> getEmployeeNewFeeds() {
		return employeeNewFeeds;
	}
	public void setEmployeeNewFeeds(List<EmployeeNewFeed> employeeNewFeeds) {
		this.employeeNewFeeds = employeeNewFeeds;
	}

	public void addEmployee(Employee emp) {
		getEmployees().add(emp);
	}
	
	public void addTweet(Tweet tweet) {
		getTweets().add(tweet);
	}
	
	public void addNewFeed(EmployeeNewFeed newFeed) {
		getEmployeeNewFeeds().add(newFeed);
	}
	
	public Employee findEmployeeById(Long id) {
		return getEmployees().stream().filter(e -> e.getEmployeeID()==id)
		.findFirst().orElse(null);
	}
	
	public List<Employee> findEmployeesByIds(List<Long> ids) {
		return getEmployees().stream().filter(e ->ids.contains(e.getEmployeeID()))
				.collect(Collectors.toList());              
	}
	
	
	public List<EmployeeNewFeed> getNewFeedTopNumerById(int topNumber,Long id) {
		return getEmployeeNewFeeds().stream().filter(nf ->nf.getEmployeeId()==id).limit(topNumber)
				.collect(Collectors.toList());              
	}
}
