package com.star.json;

import java.util.ArrayList;
import java.util.List;

import com.star.chart.PieChartInfo;

import net.sf.json.JSONObject;

public class JSONTest {

	/**
	 * jar : ezmorph-1.0.6.jar json-lib-2.3-jdk15.jar
	 * 		commons-collections-3.1.jar commons-beanutils-1.8.0.jar
	 * @param args
	 */
	
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
