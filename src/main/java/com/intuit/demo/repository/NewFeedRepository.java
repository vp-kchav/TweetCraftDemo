package com.intuit.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.intuit.demo.model.EmployeeNewFeed;

@Repository
public interface NewFeedRepository {//extends JpaRepository<EmployeeNewFeed,Serializable> {
	
    List<EmployeeNewFeed> findTop100OrderByTweetDateDESC();
}
