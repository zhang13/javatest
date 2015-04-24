package com.test.pattern.observer;

public class WangSi implements Observer {

	@Override
	public void update(String context) {
		System.out.println("王斯知道了："+context);
		toQinShiHuang(context);
	}
	
	public void toQinShiHuang(String context){
		System.out.println("秦始皇知道了："+context);
	}

}
