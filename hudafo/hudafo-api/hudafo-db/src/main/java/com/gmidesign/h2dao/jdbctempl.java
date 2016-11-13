package com.gmidesign.h2dao;

import com.gmidesign.h2dao.configuration.H2DataSourceConf;
import com.gmidesign.h2dao.datasource.H2DataSource;
import com.gmidesign.h2dao.implementation.SurnamesDaoImpl;

public class jdbctempl {
	
		
	public static void main(String[] args) {
		
		/*GenderDaoImpl impl = new GenderDaoImpl();
		impl.setDataSource(new H2DataSource(new h2DataSourceConf()).getDataSource());
		impl.create("TEstowa plec 2");
		*/
/*		NamesDaoImpl nameImpl = new NamesDaoImpl();
		nameImpl.setDataSource(new H2DataSource(new H2DataSourceConf()).getDataSource());
		nameImpl.insert("Tadziu");
*/
		SurnamesDaoImpl sur = new SurnamesDaoImpl();
		sur.setDataSource(new H2DataSource(new H2DataSourceConf()).getDataSource());
		sur.insert("Kowalski");
	}

}
