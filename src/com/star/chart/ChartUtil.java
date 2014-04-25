package com.star.chart;

import java.awt.Color;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

public class ChartUtil {
	// 主题样式
		private static Font TITLE_FONT = new Font("宋体", Font.BOLD, 22);
		// 副主题样式
		private static Font SUB_TITLE_FONT = new Font("宋书", Font.PLAIN, 15);
		// 轴向字体
		private static Font LABEL_FONT = new Font("宋体", Font.PLAIN, 15);
		// 无数据时样式
		private static Font LABEL_NO_DATA = new Font("宋体", Font.BOLD, 14);

		/**
		 * 创建3D饼图
		 * @param chartInfo
		 * @return
		 */
		public static JFreeChart createPieChart(PieChartInfo chartInfo) {
			DefaultPieDataset dataset = createPieDataset(chartInfo.getValues());
			setChartTheme();
			JFreeChart chart = ChartFactory.createPieChart3D(chartInfo.getTitle(),
					dataset, true, true, false);
			setChart(chart, chartInfo);
			setPiePlot3D((PiePlot3D) chart.getPlot());
			setPlot(chart.getPlot());
			return chart;
		}

		/**
		 * 创建3D柱状图
		 * @param chartInfo
		 * @return
		 */
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
			setChart(chart, chartInfo);
			setPlot(chart.getPlot());
			setCategoryPlot((CategoryPlot)chart.getPlot());
			return chart;
		}

		/**
		 * 创建曲线图
		 * @param chartInfo
		 * @return
		 */
		public static JFreeChart createLineChart(LineChartInfo chartInfo) {
			CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
					chartInfo.getRowKeys(), chartInfo.getColumnKeys(),
					chartInfo.getData());
			setChartTheme();
			JFreeChart chart = ChartFactory.createLineChart(chartInfo.getTitle(),
					chartInfo.getColumName(),// 目录轴的显示标签
					chartInfo.getValueName(),// 数值轴的显示标签
					dataset, // 数据集
					PlotOrientation.VERTICAL, // 图表方向：水平、垂直
					true, // 是否显示图例(对于简单的柱状图必须是false)
					true, // 是否生成工具
					false);// 是否生成URL链接
			setChart(chart, chartInfo);
			setPlot(chart.getPlot());
			setCategoryPlot((CategoryPlot)chart.getPlot());
			return chart;
		}

		/**
		 * 设置基本的表样式
		 * @param chart
		 * @param chartInfo
		 */
		public static void setChart(JFreeChart chart, BaseChartInfo chartInfo) {
			chart.getTitle().setFont(TITLE_FONT);
			chart.setBackgroundPaint(Color.WHITE);
			if (StringUtils.isNotBlank(chartInfo.getSubtitle())) {
				TextTitle subTitle = new TextTitle(chartInfo.getSubtitle());
				subTitle.setFont(SUB_TITLE_FONT);
				chart.addSubtitle(subTitle);
			}
		}

		/**
		 * 创建饼图数据集
		 * @param map
		 * @return
		 */
		public static DefaultPieDataset createPieDataset(Map<String, Number> map) {
			if (null == map || map.size() == 0) {
				return null;
			}
			DefaultPieDataset dataset = new DefaultPieDataset();
			Iterator<Entry<String, Number>> iterator = map.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<String, Number> entity = iterator.next();
				String key = entity.getKey();
				Number value = entity.getValue();
				dataset.setValue(key, value);
			}
			return dataset;
		}

		/**
		 * 设置基本图例样式
		 * @param plot
		 */
		public static void setPlot(Plot plot) {
			plot.setNoDataMessage("无数据显示");
			// 无数据时消息的样式
			plot.setNoDataMessageFont(LABEL_NO_DATA);
			// 设置透明度，0.5F为半透明，1为不透明，0为全透明
			plot.setForegroundAlpha(0.8F);
			// 设置图表背景色
			plot.setBackgroundPaint(Color.WHITE);
		}

		/**
		 * 设置曲线和柱状图的样式
		 * @param categoryPlot
		 */
		public static void setCategoryPlot(CategoryPlot categoryPlot) {
			// x轴 // 分类轴网格是否可见
			categoryPlot.setDomainGridlinesVisible(true);
			// y轴 //数据轴网格是否可见
			categoryPlot.setRangeGridlinesVisible(true);
			categoryPlot.setRangeGridlinePaint(Color.GRAY);// 虚线色彩
			categoryPlot.setDomainGridlinePaint(Color.GRAY);// 虚线色彩
			// 设置轴和面板之间的距离
			//categoryPlot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
			CategoryAxis domainAxis = categoryPlot.getDomainAxis();
			domainAxis.setLabelFont(LABEL_FONT);// 轴标题
			domainAxis.setTickLabelFont(LABEL_FONT);// 轴数值
			domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // 横轴上的
			// Lable
			// 45度倾斜
			// 设置距离图片左端距离
			domainAxis.setLowerMargin(0.0);
			// 设置距离图片右端距离
			domainAxis.setUpperMargin(0.0);
			NumberAxis numberaxis = (NumberAxis) categoryPlot.getRangeAxis();
			numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
			numberaxis.setAutoRangeIncludesZero(true);
			
			// 获得renderer 注意这里是下嗍造型到lineandshaperenderer
			//LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryPlot.getRenderer();
			//lineandshaperenderer.setBaseShapesVisible(true); // series 点（即数据点）可见
			//lineandshaperenderer.setBaseLinesVisible(true); // series 点（即数据点）间有连线可见
			// 显示折点数据
			//lineandshaperenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
			//lineandshaperenderer.setBaseItemLabelsVisible(true);
		}
	 
		/**
		 * 设置饼图图例样式
		 * @param piePlot3D
		 */
		public static void setPiePlot3D(PiePlot3D piePlot3D) {
			piePlot3D.setLabelFont(LABEL_FONT);
			// ("{0}: ({1}，{2})")是生成的格式，{0}表示section名，{1}表示section的值，{2}表示百分比。可以自定义。而new
			// DecimalFormat("0.00%")表示小数点后保留两位。
			StandardPieSectionLabelGenerator standarPieIG = new StandardPieSectionLabelGenerator(
					"{0}:({1},{2})", NumberFormat.getNumberInstance(),
					NumberFormat.getPercentInstance());
			piePlot3D.setLabelGenerator(standarPieIG);
			piePlot3D.setLabelGap(0.02D);
			// 设置开始角度
			piePlot3D.setStartAngle(120D);
			// 设置方向为”顺时针方向“
			piePlot3D.setDirection(Rotation.CLOCKWISE);
			// 设置扇区边框不可见
			piePlot3D.setSectionOutlinesVisible(false);
			// 设置扇区边框不可见
			piePlot3D.setSectionOutlinesVisible(false);
		}

		/**
		 * 设置整个图标的显示字体
		 */
		public static void setChartTheme() {
			// 创建主题样式
			StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
			// 设置标题字体
			standardChartTheme.setExtraLargeFont(TITLE_FONT);
			// 设置图例的字体
			standardChartTheme.setRegularFont(SUB_TITLE_FONT);
			// 设置轴向的字体
			standardChartTheme.setLargeFont(LABEL_FONT);
			// 应用主题样式
			ChartFactory.setChartTheme(standardChartTheme);
		}
}