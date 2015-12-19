package com.earner.info.core.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.earner.info.common.LogInPojo;
import com.earner.info.core.dao.UsersDao;
import com.earner.info.core.model.User;
import com.earner.info.query.rowmapper.UserRowMapper;
@Component
public class UsersDaoImpl implements UsersDao{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<User> getAllUsers() {
		String contentIfExist = "select user_id,user_name,user_password,first_name,last_name,city,state from  users";
		List<User> users = jdbcTemplate.query(contentIfExist, new UserRowMapper(), new Object[]{});
		return users;

	}
	@Override
	public void saveOrUpdate(User user) {
		String insertSql = "insert into users(user_id,user_name,user_password,first_name,last_name,city,state) values(nextval('users_user_id_seq'),?,?,?,?,?,?)";
		jdbcTemplate.update(insertSql,user.getUserName(),user.getPassword(),user.getFirstName(),user.getLastName(),user.getCity(),user.getState());
	}
	@Override
	public boolean isAuthenticated(LogInPojo loginPojo) {
		String contentIfExist = "select user_id,user_name,user_password,first_name,last_name,city,state from  users where user_name=? and user_password = ?";
		List<User> users = jdbcTemplate.query(contentIfExist, new UserRowMapper(), new Object[]{loginPojo.getUserName(),loginPojo.getPassword()});
		if(users != null && users.size() > 0){
			return true;
		}
		else{
			return false;
		}
	}
	@Override
	public User findUserByName(String userName) {
		String contentIfExist = "select user_id,user_name,user_password,first_name,last_name,city,state from  users where user_name=?";
		List<User> users = jdbcTemplate.query(contentIfExist, new UserRowMapper(), new Object[]{userName});
		if(users != null && users.size() > 0){
			return users.get(0);
		}
		else{
			return null;
		}
	}

}
