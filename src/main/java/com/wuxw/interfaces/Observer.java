package com.wuxw.interfaces;
/**
 * 这是一个观察者接口,定义一个更新的接口给哪些在目标发生改变的时候被通知对象;
 * @author Administrator
 *
 */
public interface Observer {

	void update(Subject subject);

}
