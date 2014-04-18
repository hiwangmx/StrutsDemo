package com.star.json;

import java.util.ArrayList;
import java.util.List;

import com.star.chart.PieChartInfo;

import net.sf.json.JSONObject;

public class JSONTest {

	public static void main(String[] args) {
		List<PieChartInfo> listStr = new ArrayList<PieChartInfo>();
		PieChartInfo pieChart1 = new PieChartInfo("one", "1");
		PieChartInfo pieChart2 = new PieChartInfo("two", "2");
		listStr.add(pieChart1);
		listStr.add(pieChart2);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.element("23", listStr);
		System.out.println(jsonObject.toString());
	}
	
}
