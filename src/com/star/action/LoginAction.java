package com.star.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.star.action.base.BaseAction;
import com.star.bean.BaseMode;
import com.star.chart.ChartInfo;
import com.star.chart.ChartUtil;

@SuppressWarnings("serial")
public class LoginAction extends BaseAction implements SessionAware,ModelDriven<BaseMode>{
	
	private Logger logger = Logger.getLogger(BaseAction.class);
	private JFreeChart chart;
	private Map session;
	private BaseMode baseMode = new BaseMode();
	
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
	
	/**
	 * @return
	 * @throws IOException
	 */
	public String chart() throws IOException{
			
			ChartInfo chartInfo = new ChartInfo();
			chartInfo.setTitle("sss");
			chartInfo.setSubtitle("22");
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("sss", 11);
			map.put("dd", 222);
			chartInfo.setValues(map);
			this.chart = ChartUtil.createPieChart(chartInfo);
	        
	        return SUCCESS;
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
	
	 public JFreeChart getChart() {
	        return chart;
	    }

	    public void setChart(JFreeChart chart) {
	        this.chart = chart;
	    }

}
