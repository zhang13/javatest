package example.startstopthread;

import static org.junit.Assert.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class StartStopSynchronizedThread extends Thread {

    private CountDownLatch threadStarted;
    private CountDownLatch threadStopped;

    public StartStopSynchronizedThread(Runnable runnable) {
        super(runnable);
        threadStarted = new CountDownLatch(1);
        threadStopped = new CountDownLatch(1);
    }

    @Override
    public void run() {
        threadStarted.countDown();
        super.run();
        threadStopped.countDown();
    }

    public void waitForStarted(long timeout, TimeUnit unit)
           throws InterruptedException {
        assertTrue("Thread not started within timeout", 
                   threadStarted.await(timeout, unit));
    }

    public void waitForStopped(long timeout, TimeUnit unit)
           throws InterruptedException {
        assertTrue("Thread not stopped within timeout", 
                   threadStopped.await(timeout, unit));
    }
}
