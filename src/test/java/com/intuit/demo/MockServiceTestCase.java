package com.intuit.demo;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.intuit.demo.service.impl.EmployeeServiceImpl;
import com.intuit.demo.service.impl.NewFeedServiceImpl;
import com.intuit.demo.service.impl.TweetServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@ComponentScan
public class MockServiceTestCase {

	@LocalServerPort
    int port;

	@Mock
	EmployeeServiceImpl employeeService;
	
	@Mock
	NewFeedServiceImpl newFeedService;
	
	@Mock
	TweetServiceImpl tweetService;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testMockCreation() {
		assertNotNull(employeeService);
		assertNotNull(newFeedService);
		assertNotNull(tweetService);
	}
}