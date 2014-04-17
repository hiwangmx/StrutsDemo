package com.star.chart;

import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

public class ChartUtil {
	// 主题样式
	private static Font TITLE_FONT = new Font("宋体", Font.BOLD, 22);
	// 扇区标签样式
	private static Font LABEL_FONT = new Font("宋体", Font.PLAIN, 15);
	// 无数据时样式
	private static Font LABEL_NO_DATA = new Font("宋体", Font.BOLD, 14);

	public static JFreeChart createPieChart(PieChartInfo chartInfo) {
		DefaultPieDataset dataset = createPieDataset(chartInfo.getValues());
		setChartTheme();
		JFreeChart chart = ChartFactory.createPieChart3D(chartInfo.getTitle(),
				dataset, true, true, false);
		setPieChart(chart, chartInfo);
		setPioPlot3D((PiePlot3D) chart.getPlot());
		return chart;
	}

	public static JFreeChart createBarChart(BarChartInfo chartInfo) {
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
				chartInfo.getRowKeys(), chartInfo.getColumnKeys(),
				chartInfo.getData());
		setChartTheme();
		JFreeChart chart = ChartFactory.createBarChart3D(chartInfo.getTitle(),
				chartInfo.getColumName(),// 目录轴的显示标签
				chartInfo.getValueName(),// 数值轴的显示标签
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				true, // 是否显示图例(对于简单的柱状图必须是false)
				false, // 是否生成工具
				false);// 是否生成URL链接
		return chart;
	}

	public static void setPieChart(JFreeChart chart, PieChartInfo chartInfo) {
		chart.getTitle().setFont(TITLE_FONT);
		if (StringUtils.isNotBlank(chartInfo.getSubtitle())) {
			chart.addSubtitle(new TextTitle(chartInfo.getSubtitle()));
		}
		chart.setBackgroundPaint(Color.LIGHT_GRAY);
	}

	public static DefaultPieDataset createPieDataset(Map<String, Integer> map) {
		if (null == map || map.size() == 0) {
			return null;
		}
		DefaultPieDataset dataset = new DefaultPieDataset();
		Iterator<Entry<String, Integer>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, Integer> entity = iterator.next();
			String key = entity.getKey();
			Integer value = entity.getValue();
			dataset.setValue(key, value);
		}
		return dataset;
	}

	public static void setPioPlot3D(PiePlot3D piePlot3D) {
		piePlot3D.setLabelFont(LABEL_FONT);
		// ("{0}: ({1}，{2})")是生成的格式，{0}表示section名，{1}表示section的值，{2}表示百分比。可以自定义。而new
		// DecimalFormat("0.00%")表示小数点后保留两位。
		StandardPieSectionLabelGenerator standarPieIG = new StandardPieSectionLabelGenerator(
				"{0}:({1},{2})", NumberFormat.getNumberInstance(),
				NumberFormat.getPercentInstance());
		piePlot3D.setLabelGenerator(standarPieIG);
		piePlot3D.setNoDataMessage("无数据显示");
		// 无数据时消息的样式
		piePlot3D.setNoDataMessageFont(LABEL_NO_DATA);
		piePlot3D.setLabelGap(0.02D);
		// 设置开始角度
		piePlot3D.setStartAngle(120D);
		// 设置方向为”顺时针方向“
		piePlot3D.setDirection(Rotation.CLOCKWISE);
		// 设置透明度，0.5F为半透明，1为不透明，0为全透明
		piePlot3D.setForegroundAlpha(0.5F);
		// 设置图表背景色
		piePlot3D.setBackgroundPaint(Color.WHITE);
		// 设置扇区边框不可见
		piePlot3D.setSectionOutlinesVisible(false);
	}

	public static void setChartTheme() {
		// 创建主题样式
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
		// 设置标题字体
		standardChartTheme.setExtraLargeFont(new Font("宋书", Font.BOLD, 20));
		// 设置图例的字体
		standardChartTheme.setRegularFont(new Font("宋书", Font.PLAIN, 15));
		// 设置轴向的字体
		standardChartTheme.setLargeFont(new Font("宋书", Font.PLAIN, 15));
		// 应用主题样式
		ChartFactory.setChartTheme(standardChartTheme);
	}
}
