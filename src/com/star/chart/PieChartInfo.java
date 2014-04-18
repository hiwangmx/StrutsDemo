package com.star.chart;

import java.util.Map;

public class PieChartInfo  extends BaseChartInfo{

	private Map<String, Integer> values;

	public PieChartInfo(){
		
	}
	
	public PieChartInfo(String title, String subtitle){
		this.setTitle(title);
		this.setSubtitle(subtitle);
	}
	
	public Map<String, Integer> getValues() {
		return values;
	}

	public void setValues(Map<String, Integer> values) {
		this.values = values;
	}

}
