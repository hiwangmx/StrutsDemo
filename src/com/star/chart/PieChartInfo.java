package com.star.chart;

import java.util.Map;

public class PieChartInfo  extends BaseChartInfo{

	private Map<String, Integer> values;

	public Map<String, Integer> getValues() {
		return values;
	}

	public void setValues(Map<String, Integer> values) {
		this.values = values;
	}

}
