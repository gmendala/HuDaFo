package com.gmidesign.h2dao.implementation;

import java.util.List;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gmidesign.h2dao.model.Gender;
import com.gmidesign.h2dao.model.GenderDao;
import com.gmidesign.h2dao.model.base.CreateTable;
import com.gmidesign.h2dao.model.base.VerifyTableExistence;
import com.gmidesign.h2dao.model.rowmappers.GendersRowMapper;

public class GenderDaoImpl implements GenderDao, VerifyTableExistence, CreateTable{

	private JdbcDataSource ds;
	private JdbcTemplate templ;
	
	
	private String SQL_CREATE = "CREATE TABLE genders(gender_id BIGINT PRIMARY KEY AUTO_INCREMENT, gender_name VARCHAR(255));";
	private String SQL_VERIFY = "SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'GENDERS' AND TABLE_SCHEMA = 'PUBLIC'";
	private String SQL_INSERT = "INSERT INTO genders (gender_name) values (?)";
	private String SQL_SELECT_BY_ID = "SELECT * FROM genders WHERE gender_id = ?";
	private String SQL_SELECT_ALL = "SELECT * FROM genders";
	private String SQL_DELETE = "DELETE FROM genders WHERE gender_id = ?";
	private String SQL_UPDATE = "UPDATE genders set gender_name = ? WHERE gender_id = ?";
	
	public void setDataSource(JdbcDataSource dataSource) {
		ds = dataSource;
		templ = new JdbcTemplate(ds);		
		if(!this.verifyTableExistence()){
			createTable();
		}
		return;
	}

	public void create(String name) {
		templ.update(SQL_INSERT, name);
		System.out.println("Created gender named " + name);
		return;
	}

	public Gender getGender(int id) {
		Gender gender = templ.queryForObject(SQL_SELECT_BY_ID, new Object[]{id}, new GendersRowMapper());
		return gender;
	}

	public List<Gender> getGenders() {
		List<Gender> genders = templ.query(SQL_SELECT_ALL, new GendersRowMapper());
		return genders;
	}

	public void delete(Integer id) {
		templ.update(SQL_DELETE, id);
		System.out.println("Gender by id: " + id + " has been deleted.");
		return;
	}

	public void update(Integer id, String name) {
		templ.update(SQL_UPDATE, name, id);
		System.out.println("Updated gender by id = " + id + " with name value = " + name);
		return;
	}

	public boolean verifyTableExistence() {
		Integer result = templ.queryForObject(SQL_VERIFY, Integer.class);
		return result > 0;
	}

	public void createTable() {
		templ.execute(SQL_CREATE);
		System.out.println("Table names has been created.");
	}
}
