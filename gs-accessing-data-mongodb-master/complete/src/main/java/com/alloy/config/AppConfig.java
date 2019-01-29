package com.alloy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.alloy.util.DBDetail;
import com.mongodb.MongoClient;

@Configuration
public class AppConfig {

	@Autowired
	private final DBDetail dbDetail;

	public @Bean MongoClient mongoClient() {

		System.out.println("dbDetail.getHost()  + " + dbDetail.getHost());
		return new MongoClient("localhost");
	}

	public AppConfig(DBDetail dbDetail) {
		this.dbDetail = dbDetail;
	}

	public @Bean MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongoClient(), "alloypocs");
	}
}
