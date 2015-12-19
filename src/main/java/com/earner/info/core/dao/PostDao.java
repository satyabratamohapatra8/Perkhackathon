package com.earner.info.core.dao;

import java.util.List;

import com.earner.info.core.model.Post;

public interface PostDao {
	public List<Post> getAllQuestionsPostOfUser(long uid);
	public List<Post> getAllQuestionsPostOfAllByState(String state);
	public List<Post> getAllQuestionsPostOfAllByStateByCity(String state, String city);
	public long saveOrUpdatePost(Post dwp);
}
