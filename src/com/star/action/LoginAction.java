package com.star.action;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.star.action.base.BaseAction;
import com.star.bean.BaseMode;

@SuppressWarnings("serial")
public class LoginAction extends BaseAction implements SessionAware,ModelDriven<BaseMode>{
	
	private Logger logger = Logger.getLogger(BaseAction.class);
	
	private Map session;
	private BaseMode baseMode;
	
	public String login(){
		logger.info("loginactino login");
		baseMode = baseMode == null ? new BaseMode() : baseMode;
		String userName = baseMode.getUserName();
		String password = baseMode.getPassword();
		if(StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(password)){
			session.put(USER_NAME, userName);
			session.put(PASSWORD, password);
			this.setMessage("Login Success");
			return Action.SUCCESS;
		}else{
			logger.info("loginactino login userName or password is null");
			this.setMessage("Login Failure");
			return Action.INPUT;
		}
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
