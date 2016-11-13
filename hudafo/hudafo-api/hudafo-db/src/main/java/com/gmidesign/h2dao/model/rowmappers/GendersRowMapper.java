package com.gmidesign.h2dao.model.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gmidesign.h2dao.model.Gender;

public class GendersRowMapper implements RowMapper<Gender>{

	public Gender mapRow(ResultSet rs, int rowNumber) throws SQLException {
		Gender gender = new Gender();
		gender.setGender_id(rs.getInt("gender_id"));
		gender.setName(rs.getString("name"));
		return gender;
	}
}
