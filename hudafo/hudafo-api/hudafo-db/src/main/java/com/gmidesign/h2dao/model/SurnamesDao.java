package com.gmidesign.h2dao.model;

import java.util.List;

import org.h2.jdbcx.JdbcDataSource;

public interface SurnamesDao {

	public void setDataSource(JdbcDataSource dataSource);
	public void insert(String name);
	public Surname getSurname(int id);
	public List<Surname> getSurnames();
	public void delete(Integer id);
	public void update(Integer id, String name);

}
