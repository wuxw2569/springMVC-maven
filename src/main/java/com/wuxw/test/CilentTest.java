package com.wuxw.test;

import com.wuxw.interfaces.impl.ConcreteObserver;
import com.wuxw.interfaces.impl.ConcreteSubject;

public class CilentTest {
	public static void main(String[] args) {
		//1.创建目标
		ConcreteSubject weather = new ConcreteSubject();
		
		//2.创建观察者
		ConcreteObserver observerGirl = new ConcreteObserver();
		observerGirl.setObserverName("黄明的女朋友");
		observerGirl.setRemindThing("是我们的第一次约会,地点街心公园");
		
		ConcreteObserver observerMom = new ConcreteObserver();
		observerMom.setObserverName("黄明他妈");
		observerMom.setRemindThing("可以去逛街");
		
		// 注册观察者
		weather.attach(observerGirl);
		weather.attach(observerMom);

		// 发布天气
		weather.setWeatherContext("今天天气晴朗,空气温度28°C");
	}
}
