package com.gmidesign.h2dao.model;

import java.util.List;

import org.h2.jdbcx.JdbcDataSource;

public interface GenderDao {
	
	public void setDataSource(JdbcDataSource dataSource);
	public void create(String name);
	public Gender getGender(int id);
	public List<Gender> getGenders();
	public void delete(Integer id);
	public void update(Integer id, String name);
	
}
