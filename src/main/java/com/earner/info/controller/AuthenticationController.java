package com.earner.info.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.earner.info.common.ResponseBase;

@Controller
public class AuthenticationController {
	private static final Logger log = Logger.getLogger(AuthenticationController.class.getName());
	
	@RequestMapping(value="/authenticate.htm")
	@ResponseBody
	 public String authenticate(HttpServletRequest request) {
			String inUserName = request.getParameter("userName");
			String inPassword = request.getParameter("password");

	        boolean isAuthenticated;
	        String message = "";
	            try {
	                if (authenticate(inUserName, inPassword)) {
	                	isAuthenticated = true;
	                	message = "Authentication successful";
	                }
	                else {
	                	isAuthenticated = false;
	                	message = "Authentication failed";
	                }
	            }
	            catch (RuntimeException re) {
	            	isAuthenticated = false;
	            }
	            if(isAuthenticated){
	            	request.getSession().setAttribute("loggedUser", inUserName);
	            }
//	        }
	        ResponseBase rs = new ResponseBase();
	        ObjectMapper mapper = new ObjectMapper();
	        String responseString = "";
			try {
				responseString = mapper.writeValueAsString(rs);
			} catch (JsonGenerationException e) {
				log.error("Error ----", e);
				e.printStackTrace();
			} catch (JsonMappingException e) {
				log.error("Error -------", e);
				e.printStackTrace();
			} catch (IOException e) {
				log.error("Error ----     ----------- --", e);
				e.printStackTrace();
			}
	        return responseString;
	    }
	@RequestMapping(value="/logout.htm")
	public ModelAndView logout(HttpServletRequest request) {
		if(request.getSession(false) != null){
			request.getSession(false).invalidate();
		}
		
		return new ModelAndView("login");
	}
	 private boolean authenticate(String username,String password)
		{
		 
		 	
			try
			{
				
				
		      }
			catch(Exception ex)
			{
				log.error("Error Occurred",ex) ;
				return false ;
			}
		
			return true ;
		}
	
}
