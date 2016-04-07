package com.epam.connectionPool.DBResourceManager;

import java.util.ResourceBundle;

public class DBResourceManager {
	private final static DBResourceManager instances = new DBResourceManager();
	private ResourceBundle bundle = ResourceBundle.getBundle("db");
	
	public static DBResourceManager getInstance(){
		return instances;
	}
	public String getValue(String key){
		return bundle.getString(key);		
	}
	
}
