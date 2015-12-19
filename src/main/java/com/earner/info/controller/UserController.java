package com.earner.info.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.earner.info.common.LogInPojo;
import com.earner.info.common.PublishPostRequest;
import com.earner.info.common.ResponseBase;
import com.earner.info.core.model.Post;
import com.earner.info.core.model.User;
import com.earner.info.core.service.impl.AppsAholicApiImpl;

@RestController
public class UserController {
	@Autowired
	AppsAholicApiImpl appsAholicApiImpl;
	@RequestMapping(value="/user/signUp",  method = RequestMethod.POST)
    public ResponseBase greeting(@RequestBody User user) {
        boolean isSignUpSuccess = appsAholicApiImpl.userSignUp(user);
        ResponseBase rs = new ResponseBase();
        if(isSignUpSuccess){
            rs.setError(false);
            rs.setErrorMessage("Sucessfully Registered");
        }
        else{
            rs.setError(true);
            rs.setErrorMessage("Signup failed");
        }
        
        return rs;
    }
	@RequestMapping(value="/user/signIn",  method = RequestMethod.POST)
    public ResponseBase greeting(@RequestBody LogInPojo loginPojo,@RequestHeader(value="userName") String userName,
    		@RequestHeader(value="password") String password) {
		
        boolean isSignUpSuccess = isAuthenticated(userName, password);
        ResponseBase rs = new ResponseBase();
        if(isSignUpSuccess){
            rs.setError(false);
            rs.setErrorMessage("user logged in");
        }
        else{
            rs.setError(true);
            rs.setErrorMessage("Login failed");
        }
        
        return rs;
    }
	 @RequestMapping(value="/")  
	 public String login() {  
	        return "welcome";  
	 }
	 @RequestMapping(value="/getUserDetails")  
	 public List<User> getUserDetails() {  
	        return appsAholicApiImpl.getAllUserData();
	 }
	 @RequestMapping(value="/getHomePageContent")  
	 public List<Post> getAllPostsForUserByCity(@RequestHeader(value="userName") String userName,@RequestHeader(value="password") String password){
		 boolean isSignUpSuccess = isAuthenticated(userName, password);
		 if(isSignUpSuccess){
			 return appsAholicApiImpl.getAllPostsForUserByCity(userName);
		 }
		 else{
			 return null;
		 }
	 }
	 @RequestMapping(value="/publishPost")  
	 public Boolean publishPost(@RequestBody PublishPostRequest post, @RequestHeader(value="userName") String userName,@RequestHeader(value="password") String password){
		 boolean isSignUpSuccess = isAuthenticated(userName, password);
		 if(isSignUpSuccess){
			 return appsAholicApiImpl.publishPost(userName, post);
		 }
		 else{
			 return null;
		 }
	 }
	 private boolean isAuthenticated(String userName, String password){
		 LogInPojo data = new LogInPojo();
			data.setPassword(password);
			data.setUserName(userName);
	        boolean isSignUpSuccess = appsAholicApiImpl.isAuthenticated(data);
	        return isSignUpSuccess;
	 }
}
