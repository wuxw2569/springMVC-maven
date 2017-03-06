package com.wuxw.interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 * 目标对象,它知道他的观察者,并提供注册和删除观察者接口
 * @author Administrator
 *
 */
public class Subject {
	private List<Observer> observers = new ArrayList<Observer>();
	
	/**
	 * 新增观察者
	 * @param obj
	 */
	public void attach(Observer obj){
		observers.add(obj);
	}
	/**
	 * 移除观察者
	 * @param obj
	 */
	public void detach(Observer obj){
		observers.remove(obj);
	}
	/**
	 * 通知所有注册的观察者对象
	 */
	protected void notifyObservers(){
		for (Observer observer : observers) {
			observer.update(this);
		}
	}
	
}
