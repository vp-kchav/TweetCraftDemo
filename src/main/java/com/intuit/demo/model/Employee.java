/**
 * created January, 26, 2019
 */
package com.intuit.demo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author kchav
 *
 */
public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long employeeID;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String gender;
	private int numberOfTweet=0;
	
	public Employee() {
		
	}
	
	public Employee(Long id, String fname, String lname,Date dob,String gender) {
		employeeID = id;
		firstName = fname;
		lastName = lname;
		dateOfBirth = dob;
		this.gender = gender; 
		this.numberOfTweet = 0;
	}
	
	public Long getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(Long employeeID) {
		this.employeeID = employeeID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getNumberOfTweet() {
		return numberOfTweet;
	}
	public void setNumberOfTweet(int numberOfTweet) {
		this.numberOfTweet = numberOfTweet;
	}
	
	public String toString() {
		return employeeID + "; " + firstName + ", "+ lastName
				+"; " + dateOfBirth + "; " + gender + "; " + numberOfTweet;
	}
	
}
