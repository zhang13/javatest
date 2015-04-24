package com.test.pattern.command;

public class StartCommand extends Command {

	public StartCommand(Reviever reciever) {
		super(reciever);
	}

	@Override
	public void execute() {
		super.reciever.action("start");
	}

}
