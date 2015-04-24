package com.test.pattern.command;
/**
 * 命令接收者
 * @author 张超
 *
 * Dec 17, 2012
 */
public class Invoker {

	private Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void execute() {
		this.command.execute();
	}
}
