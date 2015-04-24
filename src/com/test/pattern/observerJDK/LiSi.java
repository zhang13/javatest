package com.test.pattern.observerJDK;

import java.util.Observable;
import java.util.Observer;

public class LiSi implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("李斯知道了"+arg.toString());
		toQinShiHuang(arg.toString());
	}
	
	public void toQinShiHuang(String context){
		System.out.println("秦始皇知道了："+context);
	}

}
