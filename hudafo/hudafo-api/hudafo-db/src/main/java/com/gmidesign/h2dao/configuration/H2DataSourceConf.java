package com.gmidesign.h2dao.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class H2DataSourceConf  implements H2DSConfiguration{

	private static String DB_URL = "H2_DB_URL";
	private static String DB_USER = "H2_DB_USERNAME";
	private static String DB_PASSWORD = "H2_DB_PASSWORD";
	
	private String url;
	private String user;
	private String password; 
	
	private Properties dataSourceProps;
		
	public H2DataSourceConf() {
		this.init();
		this.configureDataSource();
	}
	
	private void init(){
		try {
			FileInputStream file = new FileInputStream("resources/db.properties");
			dataSourceProps = new Properties();
			try {
				dataSourceProps.load(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void configureDataSource(){
		if(dataSourceProps != null){
			url = dataSourceProps.getProperty(DB_URL);
			user = dataSourceProps.getProperty(DB_USER);
			password = dataSourceProps.getProperty(DB_PASSWORD);
		}
	}

	public String getUrl() {
		return url;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}
}
