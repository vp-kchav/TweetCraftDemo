/**
 * Created January 26,2019
 */
package com.intuit.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.gson.Gson;
import com.intuit.demo.model.request.TweetRequestBody;


/**
 * @author kimtey
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void testGetProductById() {
        ResponseEntity<String> response = restTemplate.getForEntity("/feed?empId=3&number=3", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    
    @Test
    public void testTweetNullFrom() {
		TweetRequestBody body = new TweetRequestBody();
		body.setMessage("heelo");
		Gson gson = new Gson();
		String bodyPayload = gson.toJson(body);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(bodyPayload, headers);
		ResponseEntity<String> response = restTemplate.exchange("/v1/tweet",HttpMethod.POST, entity, String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @Test
    public void testTweetMessagePositive() {
    	List<Long> tweetTo = new ArrayList<>();
    	tweetTo.add(3l);tweetTo.add(4l);
		TweetRequestBody body = new TweetRequestBody();
		body.setMessage("heelo");
		body.setTweetFrom(1l);
		body.setTweetTo(tweetTo);
		Gson gson = new Gson();
		String bodyPayload = gson.toJson(body);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(bodyPayload, headers);
		ResponseEntity<String> response = restTemplate.exchange("/v1/tweet",HttpMethod.POST, entity, String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    
}
