package com.wuxw.test;

import com.wuxw.interfaces.impl.ConcreteObserver;
import com.wuxw.interfaces.impl.ConcreteSubject;

public class CilentTest {
	public static void main(String[] args) {
		//1.����Ŀ��
		ConcreteSubject weather = new ConcreteSubject();
		
		//2.�����۲���
		ConcreteObserver observerGirl = new ConcreteObserver();
		observerGirl.setObserverName("������Ů����");
		observerGirl.setRemindThing("�����ǵĵ�һ��Լ��,�ص���Ĺ�԰");
		
		ConcreteObserver observerMom = new ConcreteObserver();
		observerMom.setObserverName("��������");
		observerMom.setRemindThing("����ȥ���");
		
		// ע��۲���
		weather.attach(observerGirl);
		weather.attach(observerMom);

		// ��������
		weather.setWeatherContext("������������,�����¶�28��C");
	}
}
