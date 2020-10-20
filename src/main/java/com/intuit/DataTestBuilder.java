package com.intuit;

import java.util.ArrayList;
import java.util.List;

import com.intuit.demo.model.Employee;
import com.intuit.demo.utils.ApplicationConstants;
import com.intuit.demo.utils.DateTimeUtils;

public class DataTestBuilder {
	
	public static List<Employee> buildEmployeeData() {
		List<Employee> employees = new ArrayList<Employee>();
		Employee emp1 = new Employee(1l,"kimtey","Chav",DateTimeUtils.getDateFromString("07/01/1988", ApplicationConstants.DOB_FORMAT),"Male");
		employees.add(emp1);
		Employee emp2 = new Employee(2l,"Panhaseth","Chav",DateTimeUtils.getDateFromString("07/01/1990", ApplicationConstants.DOB_FORMAT),"Male");
		employees.add(emp2);
		Employee emp3 = new Employee(3l,"Raghu","Chav",DateTimeUtils.getDateFromString("01/06/1980", ApplicationConstants.DOB_FORMAT),"Male");
		employees.add(emp3);
		Employee emp4 = new Employee(4l,"Sovannary","Chav",DateTimeUtils.getDateFromString("06/151/1990", ApplicationConstants.DOB_FORMAT),"Female");
		employees.add(emp4);
		Employee emp5 = new Employee(5l,"Sivali","Kumar",DateTimeUtils.getDateFromString("01/01/1988", ApplicationConstants.DOB_FORMAT),"Female");
		employees.add(emp5);
		Employee emp6 = new Employee(6l,"Theary","Thai",DateTimeUtils.getDateFromString("02/13/1990", ApplicationConstants.DOB_FORMAT),"Female");
		employees.add(emp6);
		return employees;
	}
	
}
