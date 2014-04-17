package com.star.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.jfree.chart.JFreeChart;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.star.action.base.BaseAction;
import com.star.bean.BaseMode;
import com.star.chart.BarChartInfo;
import com.star.chart.ChartUtil;
import com.star.chart.PieChartInfo;

@SuppressWarnings("serial")
public class LoginAction extends BaseAction implements SessionAware,
		ModelDriven<BaseMode> {

	private Logger logger = Logger.getLogger(BaseAction.class);
	private JFreeChart chart;
	private Map session;
	private BaseMode baseMode = new BaseMode();

	public String login() {
		logger.info("loginactino login");
		baseMode = baseMode == null ? new BaseMode() : baseMode;
		String userName = baseMode.getUserName();
		String password = baseMode.getPassword();
		if (StringUtils.isNotBlank(userName)
				&& StringUtils.isNotBlank(password)) {
			session.put(USER_NAME, userName);
			session.put(PASSWORD, password);
			this.setMessage("Login Success");
			return Action.SUCCESS;
		} else {
			logger.info("loginactino login userName or password is null");
			this.setMessage("Login Failure");
			return Action.INPUT;
		}
	}

	/**
	 * @return
	 * @throws IOException
	 */
	public String chart() throws IOException {

		PieChartInfo chartInfo = new PieChartInfo();
		chartInfo.setTitle("XX某季度业绩");
		chartInfo.setSubtitle("第一季");
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("01月", 100);
		map.put("02月", 200);
		map.put("03月", 300);
		chartInfo.setValues(map);
		
		BarChartInfo barChartInfo = new BarChartInfo();
		double[][] data = new double[][] { { 672, 766, 223, 540, 126 } };
		String[] rowKeys = { "苹果" };
		String[] columnKeys = { "北京", "上海", "广州", "成都", "深圳" };
		barChartInfo.setTitle("XX某季度业绩");
		barChartInfo.setData(data);
		barChartInfo.setColumName("sdsd");
		barChartInfo.setColumnKeys(columnKeys);
		barChartInfo.setRowKeys(rowKeys);
		barChartInfo.setValueName("sdds");
		
		this.chart = ChartUtil.createBarChart(barChartInfo);
		return SUCCESS;
	}

	public String loginExcep() throws Exception {
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
