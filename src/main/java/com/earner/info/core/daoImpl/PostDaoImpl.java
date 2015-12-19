package com.earner.info.core.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.earner.info.core.dao.PostDao;
import com.earner.info.core.model.Post;
import com.earner.info.query.rowmapper.PostRowMapper;
@Component
public class PostDaoImpl implements PostDao{
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public List<Post> getAllQuestionsPostOfUser(long uid) {
		String contentIfExist = "select post_id,posted_by,post_content,post_type from post";
		List<Post> posts = jdbcTemplate.query(contentIfExist, new PostRowMapper(), new Object[]{});
		return posts;
	}

	@Override
	public long saveOrUpdatePost(Post post) {
		String maxDocIdQuery = "select nextval('posts_post_id_seq')";
		long maxDocId = jdbcTemplate.queryForLong(maxDocIdQuery);
		String insertSql = "insert into posts(post_id,posted_by,post_content,post_type) values("+maxDocId+",?,?,?)";
		jdbcTemplate.update(insertSql,post.getPostedBy(),post.getPostContent(),post.getPostType());
		return maxDocId;
	}

	@Override
	public List<Post> getAllQuestionsPostOfAllByState(String state) {
		String contentIfExist = "select post_id,posted_by,post_content,post_type from post where state=?";
		List<Post> posts = jdbcTemplate.query(contentIfExist, new PostRowMapper(), new Object[]{state});
		return posts;
	}

	@Override
	public List<Post> getAllQuestionsPostOfAllByStateByCity(String state,
			String city) {
		
		String contentIfExist = "select post_id,posted_by,post_content,post_type from post where state=? and city=?";
		List<Post> posts = jdbcTemplate.query(contentIfExist, new PostRowMapper(), new Object[]{state,city});
		return posts;
	}

}
