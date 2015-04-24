package com.test.pattern.observer;

import java.util.List;

import com.utils.ClassUtils;

public class Client {

	public static void main(String[] args) {
		//韩非子，被观察
		HanFeiZi hanfeizi = new HanFeiZi();
		
		//李斯观察者
		Observer lisi = new LiSi();
		Observer wangsi = new WangSi();

		//这样，以后添加观察者就不用改动client了。
		List<Class> observers = ClassUtils.getAllSubClassesOrInterfaceImplementsClasses(Observer.class);
		for(Class o : observers){
			try {
				hanfeizi.addObserver((Observer)o.newInstance());
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		//hanfeizi.addObserver(lisi);
		//hanfeizi.addObserver(wangsi);
		
		hanfeizi.haveBreakfast();
		hanfeizi.haveFun();
	}

}
