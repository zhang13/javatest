package example;

import java.util.concurrent.CyclicBarrier;

public class SynchedTread extends Thread{

	private CyclicBarrier entryBarrier;
    private CyclicBarrier exitBarrier;
    public SynchedTread(Runnable runnable,
    CyclicBarrier entryBarrier,CyclicBarrier exitBarrier){
        super(runnable);
        this.entryBarrier=entryBarrier;
        this.exitBarrier=exitBarrier;
    }

    @Override
    public void run() {
        try {
            entryBarrier.await();
            super.run();
	        exitBarrier.await();
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}


}
