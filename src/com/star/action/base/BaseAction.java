package com.star.action.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{

	private static final long serialVersionUID = 2494764843182092218L;
	private HttpServletRequest request;
	private String message;
	private HttpServletResponse response;
	
	public static final String USER_NAME = "userName";
	public static final String PASSWORD = "password";
	
	public HttpServletRequest getRequest(){
		this.request = ServletActionContext.getRequest();
		return this.request;
	}
	
	public HttpServletResponse getResponse(){
		this.response = ServletActionContext.getResponse();
		return this.response;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
}
