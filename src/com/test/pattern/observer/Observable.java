package com.test.pattern.observer;

/**
 * 被观察者
 * @author 张超
 * 2012-7-31上午10:33:42
 *
 */
public interface Observable {

	public void addObserver(Observer o);
	
	public void deleteObserver(Observer o);
	
	public void notifyAllObservers(String context);
}
