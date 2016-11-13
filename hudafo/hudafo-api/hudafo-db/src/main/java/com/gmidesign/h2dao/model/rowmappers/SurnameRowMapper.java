package com.gmidesign.h2dao.model.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gmidesign.h2dao.model.Surname;

public class SurnameRowMapper implements RowMapper<Surname> {

	public Surname mapRow(ResultSet rs, int rowNum) throws SQLException {
		Surname surname = new Surname();
		surname.setSurname_id(rs.getInt("surname_id"));
		surname.setSurname_value(rs.getString("surname_name"));
		return surname;
	}

}
