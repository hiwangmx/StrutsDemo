package com.star.chart;

import java.util.Map;

public class PieChartInfo  extends BaseChartInfo{

	private Map<String, Number> values;

	public PieChartInfo(){
		
	}
	
	public PieChartInfo(String title, String subtitle){
		this.setTitle(title);
		this.setSubtitle(subtitle);
	}
	
	public Map<String, Number> getValues() {
		return values;
	}

	public void setValues(Map<String, Number> values) {
		this.values = values;
	}

}
