package com.test.pattern.observer;

import java.util.ArrayList;
import java.util.List;
/**
 * 韩非子这个被观察者
 * @author 张超
 * 2012-7-31上午10:38:29
 *
 */
public class HanFeiZi implements Observable {

	private List<Observer> observers = new ArrayList<Observer>();
	
	@Override
	public void addObserver(Observer o) {
		this.observers.add(o);

	}

	@Override
	public void deleteObserver(Observer o) {
		this.deleteObserver(o);

	}

	@Override
	public void notifyAllObservers(String context) {
		for(Observer o : observers){
			o.update(context);
		}
	}
//--------------------------------------------------------------------------
	public void haveBreakfast(){
		System.out.println("韩非子:韩非子要吃饭了");
		this.notifyAllObservers("韩非子要吃饭了");
		
	}
	
	public void haveFun(){
		System.out.println("韩非子：韩非子我去逛青楼了");
		this.notifyAllObservers("韩非子去逛青楼了");
	}
	
}
