package com.alloy.config;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.alloy.controller.CustomerController;
import com.alloy.util.DBDetail;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Configuration
public class AppConfig {

	private final static Logger logger = Logger.getLogger(AppConfig.class);
	@Autowired
	private final DBDetail dbDetail;

	public @Bean MongoClient mongoClient() {
		logger.info("setting the host and the creating the mongo Client ");
		System.out.println("dbDetail.getHost()  + " + dbDetail.getHost());
		return new MongoClient("localhost");
	}

	public AppConfig(DBDetail dbDetail) {
		logger.info("reading and setting the DB detail");
		this.dbDetail = dbDetail;
	}

	public @Bean MongoTemplate mongoTemplate() {
		
		logger.info("creating the mongo template bean");
		return new MongoTemplate(mongoClient(), "alloypocs");
	}
	
	

	public @Bean MongoCollection<Document> getMongoCollection() {
		MongoDatabase database = mongoClient().getDatabase("alloypocs");
		MongoCollection<Document> collection = database.getCollection("customer");
		return collection;
	}
	  
	 
}
