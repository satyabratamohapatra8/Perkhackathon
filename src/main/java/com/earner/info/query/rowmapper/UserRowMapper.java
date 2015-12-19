package com.earner.info.query.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.earner.info.core.model.User;

public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet res, int arg1) throws SQLException {
		User user = new User();
		user.setUserId(res.getLong(1));
		user.setCity(res.getString(2));
		user.setFirstName(res.getString(3));
		user.setLastName(res.getString(4));
		user.setPassword(res.getString(5));
		user.setState(res.getString(6));
		user.setUserName(res.getString(7));
		return user;
	}

}
