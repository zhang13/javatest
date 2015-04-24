package example.startstopthread;

import java.util.concurrent.ThreadFactory;

public class Server extends Thread{

	private ThreadFactory threadFactory;
	public void setThreadFactory(ThreadFactory threadFactory) {
		this.threadFactory=threadFactory;
	}
	
	@Override
	public synchronized void start() {
		threadFactory.newThread(null).start();
	}
	
}
