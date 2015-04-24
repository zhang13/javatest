package com.test.pattern.command;

public class RecieverImpl implements Reviever {

	@Override
	public void action(String orderName) {
		System.out.println(orderName+"__命令实施者干活拉。。。");

	}

}
