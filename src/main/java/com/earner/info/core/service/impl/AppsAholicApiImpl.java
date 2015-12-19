package com.earner.info.core.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.earner.info.common.LogInPojo;
import com.earner.info.common.PublishPostRequest;
import com.earner.info.core.dao.PostDao;
import com.earner.info.core.dao.UsersDao;
import com.earner.info.core.model.Post;
import com.earner.info.core.model.PostAssociation;
import com.earner.info.core.model.User;

@Component
public class AppsAholicApiImpl {
	@Autowired
	UsersDao usersDao;
	@Autowired
	PostDao postDao;
	public List<User> getAllUserData(){
		return usersDao.getAllUsers();
	}
	public boolean userSignUp(User user){
		usersDao.saveOrUpdate(user);
		return true;
	}
	public boolean publishPost(Post post){
		
		return true;
	}
	public boolean isAuthenticated(LogInPojo loginPojo) {
		return usersDao.isAuthenticated(loginPojo);
	}
	
	public List<Post> getAllPostsForUserByCity(String userName) {
		User user  = usersDao.findUserByName(userName);
		List<Post> data = postDao.getAllQuestionsPostOfAllByStateByCity(user.getState(), user.getCity());
		return data;
	}
	public boolean publishPost(String userName, PublishPostRequest post) {
		User user  = usersDao.findUserByName(userName);
		Post postData = new Post();
		postData.setPostContent(post.getPostContent());
		postData.setPostedBy(user.getUserId());
		postData.setPostType((short)1);
		long appPostId = postDao.saveOrUpdatePost(postData);
		if(post.getPostType() == 1){
			
		}
		else if(post.getPostType() == 2){
			PostAssociation pa = new PostAssociation();
			pa.setApostId(appPostId);
			pa.setQpostId(post.getPostAgainstPostId());
		}
		return true;
	}
	
}
