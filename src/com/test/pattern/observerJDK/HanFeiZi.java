package com.test.pattern.observerJDK;

import java.util.Observable;

/**
 * Observable这个类把观察者列表的添加删除通知等操作集成 了。
 * @author 张超
 * 2012-7-31上午11:06:03
 *
 */
public class HanFeiZi extends Observable{

	public void haveBreakfast(){
		System.out.println("韩非子:韩非子要吃饭了");
		this.setChanged();
		this.notifyObservers("韩非子要吃饭了");
	}
	
	public void haveFun(){
		System.out.println("韩非子：韩非子我去逛青楼了");
		this.setChanged();
		this.notifyObservers("韩非子我去逛青楼了");
	}
}
