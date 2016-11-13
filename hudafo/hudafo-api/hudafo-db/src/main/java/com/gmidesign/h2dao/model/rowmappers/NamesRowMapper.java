package com.gmidesign.h2dao.model.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gmidesign.h2dao.model.Names;

public class NamesRowMapper implements RowMapper<Names>{

	public Names mapRow(ResultSet rs, int rowNum) throws SQLException {
		Names names = new Names();
		names.setNames_id(rs.getInt("names_id"));
		names.setNames_text(rs.getString("name_text"));
		return names;
	}
}
