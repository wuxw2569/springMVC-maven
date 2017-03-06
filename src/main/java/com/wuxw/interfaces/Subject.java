package com.wuxw.interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 * Ŀ�����,��֪�����Ĺ۲���,���ṩע���ɾ���۲��߽ӿ�
 * @author Administrator
 *
 */
public class Subject {
	private List<Observer> observers = new ArrayList<Observer>();
	
	/**
	 * �����۲���
	 * @param obj
	 */
	public void attach(Observer obj){
		observers.add(obj);
	}
	/**
	 * �Ƴ��۲���
	 * @param obj
	 */
	public void detach(Observer obj){
		observers.remove(obj);
	}
	/**
	 * ֪ͨ����ע��Ĺ۲��߶���
	 */
	protected void notifyObservers(){
		for (Observer observer : observers) {
			observer.update(this);
		}
	}
	
}
