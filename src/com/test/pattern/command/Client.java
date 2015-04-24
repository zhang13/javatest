package com.test.pattern.command;

public class Client {

	public static void main(String[] args) {
		
		Reviever reciever = new RecieverImpl();
		Command command = new StartCommand(reciever);
		Invoker invoker = new Invoker();
		invoker.setCommand(command);
		invoker.execute();
		
	}
}
