package com.earner.info.query.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StringRowMapper implements RowMapper<String>{

	@Override
	public String mapRow(ResultSet res, int arg1)
			throws SQLException {
		return res.getString(1);
	}

}
