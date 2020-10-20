package com.intuit.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.intuit.demo.model.Employee;
import com.intuit.demo.service.impl.EmployeeServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@ComponentScan
public class SpringBootBaselineApplicationTests {

	@LocalServerPort
    int port;

	@Mock
	EmployeeServiceImpl employeeService;
	
	@Autowired
	private TestRestTemplate restTemplate;

//	@Test
//	public void test() {
//		Employee emp = employeeService.findEmployeeById(1l);
//		System.out.println(emp.toString());
//	}
	
	@Test
	public void testHealthCheck() {
		String body = this.restTemplate.getForObject("http://localhost:" + this.port + "/health/full", String.class);
		assertThat(body).isEqualTo("Health Check Ok");
	}
	
//	@Test
//	public void testHealthCheck1() {
//		String body = this.restTemplate.getForObject("http://localhost:" + this.port + "/feed?empId=3", String.class);
//		assertThat(body).isEqualTo("Health Check Ok");
//	}
	
	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
	}
	
}