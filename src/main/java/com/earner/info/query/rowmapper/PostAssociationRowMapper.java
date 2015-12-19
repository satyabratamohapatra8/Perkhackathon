package com.earner.info.query.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.earner.info.core.model.PostAssociation;

public class PostAssociationRowMapper implements RowMapper<PostAssociation>{

	@Override
	public PostAssociation mapRow(ResultSet res, int arg1) throws SQLException {
		PostAssociation post = new PostAssociation();
		post.setPostAssociationId(res.getLong(1));
		post.setQpostId(res.getLong(2));
		post.setApostId(res.getLong(3));
		return post;
	}

}


