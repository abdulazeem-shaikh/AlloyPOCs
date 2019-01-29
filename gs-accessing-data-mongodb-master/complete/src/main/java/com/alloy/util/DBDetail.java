package com.alloy.util;

 

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("data")
public class DBDetail {	 
	String host;
    String port;
    String  database;
    
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