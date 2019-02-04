package com.alloy.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DBDetail {

	@Value("${spring.data.mongodb.host}")
	String host;

	@Value("${spring.data.mongodb.port}")
	String port;

	@Value("${spring.data.mongodb.database}")
	String database;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

}