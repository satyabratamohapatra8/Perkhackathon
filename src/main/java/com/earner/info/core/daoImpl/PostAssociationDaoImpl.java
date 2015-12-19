package com.earner.info.core.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.earner.info.core.dao.PostAssociationDao;
import com.earner.info.core.model.PostAssociation;
import com.earner.info.query.rowmapper.PostAssociationRowMapper;
@Component
public class PostAssociationDaoImpl implements PostAssociationDao{
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public void saveOrUpdatePostAssociation(PostAssociation postAssociation) {
		String insertSql = "insert into post_association(post_association_id,question_post_id,answer_post_id) values(nextval('post_association_post_association_id_seq'),?,?)";
		jdbcTemplate.update(insertSql,postAssociation.getQpostId(),postAssociation.getApostId());
	}

	@Override
	public List<PostAssociation> getAllAssocationForUser(long uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostAssociation> getAllAssociationForQuestionPostById(
			long qpostId) {
		String contentIfExist = "select post_association_id,question_post_id,answer_post_id from post_association where question_post_id=?";
		List<PostAssociation> posts = jdbcTemplate.query(contentIfExist, new PostAssociationRowMapper(), new Object[]{qpostId});
		return posts;
	}

}
