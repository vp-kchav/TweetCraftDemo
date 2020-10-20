/**
 * created January, 26, 2019
 */
package com.intuit.demo.model;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author kchav
 *
 */
public class Follwers implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String employeeId;
	private List<Employee> follwers;
	
	public String getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	public List<Employee> getFollwers() {
		return follwers;
	}
	
	public void setFollwers(List<Employee> follwers) {
		this.follwers = follwers;
	}
	
}
