package example.startstopthread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ServerStartsAndStopsThreadTests {

    private StartStopSynchronizedThread thread;

    @Test
    public void testStartingAndStoppingServerThread() throws Exception {
        ThreadFactory threadFactory = new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                thread = new StartStopSynchronizedThread(runnable);
                return thread;
            }
        };

        Server server=new Server();
        server.setThreadFactory(threadFactory);
        server.start();
        thread.waitForStarted(1, TimeUnit.SECONDS);
        server.stop();
        thread.waitForStopped(1, TimeUnit.SECONDS);
    }
}
