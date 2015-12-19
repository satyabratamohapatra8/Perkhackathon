package com.earner.info.query.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.earner.info.core.model.Post;

public class PostRowMapper implements RowMapper<Post>{

	@Override
	public Post mapRow(ResultSet res, int arg1) throws SQLException {
		Post post = new Post();
		post.setPostId(res.getLong(1));
		post.setPostedBy(res.getLong(2));
		post.setPostContent(res.getString(3));
		post.setPostType(res.getShort(4));
		return post;
	}

}

