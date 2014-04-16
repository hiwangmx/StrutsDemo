package com.star.chart;

import java.awt.Font;
import java.io.IOException;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.util.Rotation;

public class ChartUtil {

	public static JFreeChart createPieChart(ChartInfo chartInfo){
		DefaultPieDataset dataset = createPieDataset(chartInfo.getValues());
		JFreeChart chart = ChartFactory.createPieChart(chartInfo.getTitle(), dataset, true, true, false);
		PiePlot piePlot = (PiePlot)chart.getPlot();
		piePlot.setLabelFont(new Font("宋体", 0, 11));
		piePlot.setNoDataMessage("无数据显示");  
		piePlot.setLabelGap(0.02D); 
		
		PiePlot pieplot3d = (PiePlot)chart.getPlot();  
		//设置开始角度  
		pieplot3d.setStartAngle(120D);  
		//设置方向为”顺时针方向“  
		pieplot3d.setDirection(Rotation.CLOCKWISE);  
		//设置透明度，0.5F为半透明，1为不透明，0为全透明  
		pieplot3d.setForegroundAlpha(0.7F);  
		return chart;
	}
	
	public static DefaultPieDataset createPieDataset(Map<String, Integer> map){
		if(null == map || map.size() == 0){
			return null;
		}
		DefaultPieDataset dataset = new DefaultPieDataset();
		Iterator<Entry<String, Integer>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, Integer> entity = iterator.next();
			String key = entity.getKey();
			Integer value = entity.getValue();
			dataset.setValue(key, value);
		}
		return dataset;
	}
	
}
