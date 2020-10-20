package com.intuit.demo.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.demo.datacenter.DataCenter;
import com.intuit.demo.model.EmployeeNewFeed;
import com.intuit.demo.model.Tweet;
import com.intuit.demo.model.request.TweetRequestBody;
import com.intuit.demo.service.EmployeeService;
import com.intuit.demo.service.NewFeedService;
import com.intuit.demo.service.impl.TweetServiceImpl;

/**
 * 
 * @author kchav
 *
 */
@RestController
public class TweetController {
	
	@Autowired
	DataCenter dataCenter;
	
	@Autowired
	TweetServiceImpl tweetService;
	
	@Autowired
	EmployeeService employeeService;

	@Autowired
	NewFeedService newFeedService;
	
	@Value("${newfeed.default.topnumber}")
	int defaultTopFeed;
	
	static final Logger logger = LoggerFactory.getLogger(TweetController.class);
	
	/**
	 * 
	 * @param tweetBody
	 * @return
	 */
	@PostMapping(value ="${employee.tweet}", headers="Content-Type=application/json")
	public ResponseEntity<String> tweetMessage(@RequestBody TweetRequestBody tweetBody) {
		boolean success = true; 
		try {
			if(tweetBody.getTweetFrom() == null) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request not in well format. The request should contain the person who tweet the message!");
			}
			logger.info("Payload request, {} {}",tweetBody.getTweetFrom(), tweetBody.getMessage());
			success = tweetService.tweetMessage(buildTweetObject(tweetBody));
		}catch(Exception e) {
			success= false;
		}
		if(success) {
			return ResponseEntity.status(HttpStatus.OK).body("Success");
		} else  {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
		}
	}
	
	@GetMapping(path = "{employee.feed}")
	public ResponseEntity<List<EmployeeNewFeed>> getNeewFeedByNumber(@RequestParam(value ="number",required= false) Integer number,@RequestParam("empId") Long empId){
		if(number == null) number = defaultTopFeed;
		List<EmployeeNewFeed> newFeeds = newFeedService.getTopNumberFeed(number, empId);
//		String jsonResult = new Gson().toJson(newFeeds);
		return ResponseEntity.status(HttpStatus.OK).body(newFeeds);
	}
	
	/**
	 * 
	 * @param requestBody
	 * @return
	 */
	private Tweet buildTweetObject(TweetRequestBody requestBody) {
		Tweet tweet = new Tweet();
		tweet.setMessage(requestBody.getMessage());
		tweet.setTweetDateTime(new Date());
		tweet.setTweetId(Long.valueOf(dataCenter.getTweets().size() +1));
		tweet.setTweetFrom(employeeService.findEmployeeById(requestBody.getTweetFrom()));
		tweet.setTweetTo(employeeService.findEmployeesByIds(requestBody.getTweetTo()));
		return tweet;
	}
}
