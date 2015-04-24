package com.test.pattern.command;

public class StopCommand extends Command {

	public StopCommand(Reviever reciever) {
		super(reciever);
	}

	@Override
	public void execute() {
		super.reciever.action("stop");

	}

}
