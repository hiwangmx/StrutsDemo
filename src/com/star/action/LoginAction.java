package com.star.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.star.action.base.BaseAction;

public class LoginAction extends BaseAction implements SessionAware{
	
	private Map session;
	
	public String login(){
		return "success";
	}
	
	public String error(){
		return "error";
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

}
