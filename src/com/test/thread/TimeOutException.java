package com.test.thread;

public class TimeOutException extends RuntimeException {
	
	private static final long serialVersionUID = -8078853655388692688L;
	public TimeOutException(String errMessage)
	{
		super(errMessage);
	}
}
