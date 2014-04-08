package com.star.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ModelDriven;
import com.star.action.base.BaseAction;
import com.star.bean.BaseMode;

@SuppressWarnings("serial")
public class LoginAction extends BaseAction implements SessionAware,ModelDriven<BaseMode>{
	
	private static final String USER_NAME = "userName";
	private static final String PASSWORD = "password";

	private Logger logger = Logger.getLogger(BaseAction.class);
	
	private Map session;
	private BaseMode baseMode;
	
	public String login(){
		logger.info("loginactino login");
		session.put(USER_NAME, "张三");
		session.put(PASSWORD, "123456");
		return "success";
	}
	
	public String loginExcep() throws Exception{
		throw new Exception("发生错误了");
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}

	@Override
	public BaseMode getModel() {
		// TODO Auto-generated method stub
		return baseMode;
	}

}
