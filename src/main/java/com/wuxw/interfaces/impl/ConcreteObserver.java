package com.wuxw.interfaces.impl;

import com.wuxw.interfaces.Observer;
import com.wuxw.interfaces.Subject;
/**
 * ����Ĺ۲��߶���,ʵ�ָ��µķ���,ʹ�����״̬��Ŀ���״̬����һ��
 * @author Administrator
 *
 */
public class ConcreteObserver implements Observer {

	private String observerName;
	
	private String weatherContext;
	private String remindThing;
	
	@Override
	public void update(Subject subject) {
		
		weatherContext = ((ConcreteSubject)subject).getWeatherContext();
		
		System.out.println(observerName+"�յ���"+weatherContext+","+remindThing);
	}

	public String getObserverName() {
		return observerName;
	}

	public void setObserverName(String observerName) {
		this.observerName = observerName;
	}

	public String getWeatherContext() {
		return weatherContext;
	}

	public void setWeatherContext(String weatherContext) {
		this.weatherContext = weatherContext;
	}

	public String getRemindThing() {
		return remindThing;
	}

	public void setRemindThing(String remindThing) {
		this.remindThing = remindThing;
	}
	
	
}
