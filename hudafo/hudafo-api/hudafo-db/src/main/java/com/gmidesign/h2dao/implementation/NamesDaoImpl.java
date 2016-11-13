package com.gmidesign.h2dao.implementation;

import java.util.List;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gmidesign.h2dao.model.Names;
import com.gmidesign.h2dao.model.NamesDao;
import com.gmidesign.h2dao.model.base.CreateTable;
import com.gmidesign.h2dao.model.base.VerifyTableExistence;
import com.gmidesign.h2dao.model.rowmappers.NamesRowMapper;

public class NamesDaoImpl implements NamesDao, VerifyTableExistence, CreateTable {

	private JdbcDataSource ds;
	private JdbcTemplate templ;

	
	private String SQL_CREATE = "CREATE TABLE names(names_id BIGINT PRIMARY KEY AUTO_INCREMENT, names_text VARCHAR(255));";
	private String SQL_VERIFY = "SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'NAMES' AND TABLE_SCHEMA = 'PUBLIC'";
	private String SQL_INSERT = "INSERT INTO names (names_text) values (?)";
	private String SQL_SELECT_BY_ID = "SELECT * FROM names WHERE names_id = ?";
	private String SQL_SELECT_ALL = "SELECT * FROM names";
	private String SQL_DELETE = "DELETE FROM names WHERE names_id = ?";
	private String SQL_UPDATE = "UPDATE names set name_text = ? WHERE names_id = ?";
	
	
	public void setDataSource(JdbcDataSource dataSource) {
		ds = dataSource;           
		templ = new JdbcTemplate(ds);
		if(!this.verifyTableExistence()){
			createTable();
		}
	}

	public void insert(String name) {
		templ.update(SQL_INSERT, name);
		System.out.println("Created name: " + name);
		return;
	}

	public Names getName(int id) {
		Names names = templ.queryForObject(SQL_SELECT_BY_ID, new Object[]{id}, new NamesRowMapper());
		return names;
	}

	public List<Names> getNames() {
		List<Names> names= templ.query(SQL_SELECT_ALL, new NamesRowMapper());
		return names;
	}

	public void delete(Integer id) {
		templ.update(SQL_DELETE, id);
		System.out.println("Name by id: " + id + " has been deleted.");
		return;		
	}

	public void update(Integer id, String name) {
		templ.update(SQL_UPDATE, name, id);
		System.out.println("Updated name by id = " + id + " with value = " + name);
		return;
	}

	public boolean verifyTableExistence() {
		Integer result = templ.queryForObject(SQL_VERIFY, Integer.class);
		return result > 0;
	}

	public void createTable() {
		templ.execute(SQL_CREATE);
	}
}