package com.wuxw.interfaces.impl;

import com.wuxw.interfaces.Subject;
/**
 * �����Ŀ�����,������й�״̬���뵽��Ӧ�Ĺ۲��߶�����
 * @author Administrator
 *
 */
public class ConcreteSubject extends Subject {
	private String weatherContext;

	public String getWeatherContext() {
		return weatherContext;
	}

	public void setWeatherContext(String weatherContext) {
		this.weatherContext = weatherContext;
		this.notifyObservers();
	}
	
}
