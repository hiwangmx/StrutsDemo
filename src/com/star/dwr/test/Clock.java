package com.star.dwr.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.directwebremoting.Browser;
import org.directwebremoting.ServerContextFactory;
import org.directwebremoting.ui.dwr.Util;

public class Clock implements Runnable{

	protected transient boolean active = false;
	int i = 0;
	
	public Clock() {
		// TODO Auto-generated constructor stub
		ScheduledThreadPoolExecutor  executor = new ScheduledThreadPoolExecutor(1);
		executor.scheduleAtFixedRate(this, 1, 1, TimeUnit.SECONDS);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(active){
			setClockDisplay((new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒").format(new Date())));
		}
	}
	
	public synchronized void toggle() {
		i++;
		active = ! active;
		System.out.println("toggle clocked!" + i);
		System.out.println("active: " + active);
		if(active){
			setClockDisplay("Started");
		}else{
			setClockDisplay("Stopped");
		}
	}
	
	public void setClockDisplay(final String output){
		String page = ServerContextFactory.get().getContextPath() + "/dwrTest.jsp";
		Browser.withPage(page, new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Util.setValue("clockDisplay", output);
			}
		});
	}

}
