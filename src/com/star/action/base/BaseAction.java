package com.star.action.base;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{

	private HttpServletRequest request;
	
	public HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	
}
