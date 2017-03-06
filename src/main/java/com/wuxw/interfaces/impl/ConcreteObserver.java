package com.wuxw.interfaces.impl;

import com.wuxw.interfaces.Observer;
import com.wuxw.interfaces.Subject;
/**
 * 具体的观察者对象,实现更新的方法,使自身的状态和目标的状态保持一致
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
		
		System.out.println(observerName+"收到了"+weatherContext+","+remindThing);
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
