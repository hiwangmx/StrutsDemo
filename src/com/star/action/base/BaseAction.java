package com.star.action.base;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{

	private HttpServletRequest request;
	private String message;
	
	public static final String USER_NAME = "userName";
	public static final String PASSWORD = "password";
	
	public HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
