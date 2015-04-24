package example;

import static org.junit.Assert.*;

import java.util.concurrent.CyclicBarrier;

import org.junit.Test;

public class CounterTests {
/*
    @Test
    public void testBasicFunctionality() throws Exception {
        Counter counter=new Counter();
        assertEquals(0, counter.value());
        counter.increment();
        assertEquals(1, counter.value());
        counter.increment();
        assertEquals(2, counter.value());
    }*/

	@Test
    public void testforthreadsafety() throws Exception {
        final Counter counter = new Counter();
        int numberofthreads = 20;
        final int incrementsperthread = 1000000;

        Runnable runnable = new Runnable() {
            public void run() {
                for (int i = 0; i < incrementsperthread; i++) {
                    counter.increment();
                }
            }
        };

        for (int i = 0; i < numberofthreads; i++) {
            new Thread(runnable).start();
        }

        Thread.sleep(500);
        assertEquals(numberofthreads*incrementsperthread, counter.value());
    }
/*
	   @Test
	    public void testForThreadSafetyUsingCyclicBarrierToMaximizeConcurrency()
	           throws Exception{
	        final Counter counter = new Counter();
	        int numberOfThreads = 20;
	        final int incrementsPerThread = 1000;

	        CyclicBarrier entryBarrier=
	             new CyclicBarrier(numberOfThreads+1);
	        CyclicBarrier exitBarrier=
	             new CyclicBarrier(numberOfThreads+1);

	        Runnable runnable = new Runnable() {
	            public void run() {
	                for (int i = 0; i < incrementsPerThread; i++) {
	                    counter.increment();
	                }
	            }
	        };

	        for (int i = 0; i < numberOfThreads; i++) {
	             new SynchedTread(runnable, entryBarrier,
					exitBarrier).start();
	        }
	        assertEquals(0, counter.value());
	        entryBarrier.await();
	        exitBarrier.await();
	        assertEquals(numberOfThreads*incrementsPerThread,
			            counter.value());
	    }*/
}
