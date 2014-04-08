package com.star.interceptor;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.star.action.LoginAction;
import com.star.action.base.BaseAction;

/**
 * 自定义拦截器必须要 实现Interceptor接口 或者 继承AbstractInterceptor类
 * @author john
 *
 */
public class LoginInterceptor implements Interceptor{

	private final Logger logger = Logger.getLogger(LoginInterceptor.class);
	
	private static final String USER_NAME = "userName";
	/**
	 * 拦截器被垃圾回收之前调用，用来回收init初始化的资源
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		logger.info("LoginInterceptor destroy start");
	}

	/**
	 * 拦截器创建之后，在对Action类拦截之前调用的，可以给拦截器作为必要的初始化操作
	 */
	@Override
	public void init() {
		// TODO Auto-generated method stub
		logger.info("LoginInterceptor init start");
	}
	
	/**
	 * 拦截器的主要拦截方法
	 */
	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		// TODO Auto-generated method stub
		logger.info("LoginInterceptor intercept start");
		Object action = actionInvocation.getAction();
		if(action instanceof LoginAction){
			return actionInvocation.invoke();
		}else{
			Map session = actionInvocation.getInvocationContext().getSession();
			String userName = (String)session.get(USER_NAME);
			if(StringUtils.isNotBlank(userName)){
				return actionInvocation.invoke();
			}else{
				return "failure";
			}
		}
	}

}
