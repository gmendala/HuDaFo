package com.gmidesign.h2dao.datasource;

import org.h2.jdbcx.JdbcDataSource;

import com.gmidesign.h2dao.configuration.H2DSConfiguration;

public class H2DataSource {

	private JdbcDataSource ds;	
	
	public H2DataSource(H2DSConfiguration config) {
		ds = new JdbcDataSource();
		ds.setUrl(config.getUrl());
		ds.setPassword(config.getPassword());
		ds.setUser(config.getUser());
	}
	
	public JdbcDataSource getDataSource(){
		return ds;
	}
	
	
}
