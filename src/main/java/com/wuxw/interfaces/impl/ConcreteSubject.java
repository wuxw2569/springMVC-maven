package com.wuxw.interfaces.impl;

import com.wuxw.interfaces.Subject;
/**
 * 具体的目标对象,负责吧有关状态存入到相应的观察者对象中
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
