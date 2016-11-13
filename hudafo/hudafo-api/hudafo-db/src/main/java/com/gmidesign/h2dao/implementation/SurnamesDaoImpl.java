package com.gmidesign.h2dao.implementation;

import java.util.List;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gmidesign.h2dao.model.Surname;
import com.gmidesign.h2dao.model.SurnamesDao;
import com.gmidesign.h2dao.model.base.CreateTable;
import com.gmidesign.h2dao.model.base.VerifyTableExistence;
import com.gmidesign.h2dao.model.rowmappers.SurnameRowMapper;

public class SurnamesDaoImpl implements SurnamesDao, VerifyTableExistence, CreateTable{

	private JdbcDataSource ds;
	private JdbcTemplate templ;
	
	
	private String SQL_CREATE = "CREATE TABLE surnames(surname_id BIGINT PRIMARY KEY AUTO_INCREMENT, surname_name VARCHAR(255));";
	private String SQL_VERIFY = "SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'SURNAMES' AND TABLE_SCHEMA = 'PUBLIC'";
	private String SQL_INSERT = "INSERT INTO surnames (surname_name) values (?)";
	private String SQL_SELECT_BY_ID = "SELECT * FROM surnames WHERE surname_id = ?";
	private String SQL_SELECT_ALL = "SELECT * FROM surnames";
	private String SQL_DELETE = "DELETE FROM surnames WHERE surname_id = ?";
	private String SQL_UPDATE = "UPDATE surnames set surname_name = ? WHERE surname_id = ?";
	
		
	
	public void createTable() {
		templ.execute(SQL_CREATE);
		System.out.println("Table surnames has been created.");
	}

	public boolean verifyTableExistence() {
		Integer result = templ.queryForObject(SQL_VERIFY, Integer.class);
		return result > 0;
	}

	public void setDataSource(JdbcDataSource dataSource) {
		ds = dataSource;
		templ = new JdbcTemplate(ds);		
		if(!this.verifyTableExistence()){
			createTable();
		}
		return;
	}

	public void insert(String name) {
		templ.update(SQL_INSERT, name);
		System.out.println("Created surname: " + name);
		return;
	}

	public Surname getSurname(int id) {
		Surname surname = templ.queryForObject(SQL_SELECT_BY_ID, new Object[]{id}, new SurnameRowMapper());
		return surname;
	}

	public List<Surname> getSurnames() {
		List<Surname> surname = templ.query(SQL_SELECT_ALL, new SurnameRowMapper());
		return surname;
	}

	public void delete(Integer id) {
		templ.update(SQL_DELETE, id);
		System.out.println("Surname by id: " + id + " has been deleted.");
		return;
	}

	public void update(Integer id, String name) {
		templ.update(SQL_UPDATE, name, id);
		System.out.println("Updated surname by id = " + id + " with name value = " + name);
		return;
	}

}
