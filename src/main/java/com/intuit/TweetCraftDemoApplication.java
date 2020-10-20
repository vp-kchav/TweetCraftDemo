package com.intuit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.validation.ValidationAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {ValidationAutoConfiguration.class})
@EnableScheduling
public class TweetCraftDemoApplication
{
    public static void main(String[] args) throws Exception {
        SpringApplication.run(TweetCraftDemoApplication.class, args);
        
    }
    
}