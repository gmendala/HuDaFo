package com.gmidesign.h2dao.model;

import java.util.List;

import org.h2.jdbcx.JdbcDataSource;

public interface NamesDao {

	public void setDataSource(JdbcDataSource dataSource);
	public void insert(String name);
	public Names getName(int id);
	public List<Names> getNames();
	public void delete(Integer id);
	public void update(Integer id, String name);

	
	
}
