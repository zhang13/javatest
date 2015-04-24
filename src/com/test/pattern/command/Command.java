package com.test.pattern.command;
/**
 * 命令抽象类
 * @author 张超
 * 2012-8-23下午03:57:25
 *
 */
public abstract class Command {
	protected Reviever reciever;
	
	public Command(Reviever reciever) {
		this.reciever = reciever;
	}

	public abstract void execute();
}
