package com.alloy.config;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.alloy.model.Customer;
import com.alloy.util.DBDetail;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;


@Configuration
public class AppConfig {

	private final static Logger logger = Logger.getLogger(AppConfig.class);
	
	@Inject
	private final DBDetail dbDetail;

	public @Bean MongoClient mongoClient() {
		/*logger.info("setting the host and the creating the mongo Client ");
		return new MongoClient( dbDetail.getHost());*/
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
	 	return new MongoClient("localhost", MongoClientOptions.builder().codecRegistry(pojoCodecRegistry).build());
	
	}

	public AppConfig(DBDetail dbDetail) {
		logger.info("reading and setting the DB detail");
		this.dbDetail = dbDetail;
	}

	public @Bean MongoTemplate mongoTemplate() {				
		System.out.println("dbDetail Database"+dbDetail.getDatabase());
		logger.info("creating the mongo template bean");
		return new MongoTemplate(mongoClient(),  dbDetail.getDatabase());
	}
	

	public @Bean MongoCollection<Customer> getMongoCollection() {
		
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		
		logger.info("Getting the ");
		MongoDatabase database = mongoClient().getDatabase("alloypocs");
		MongoCollection<Customer> collection = database.getCollection("customer", Customer.class);
		return collection;
	}
	  
	 
}
