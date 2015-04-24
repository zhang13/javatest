package example;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    private int counter;

    public int value() {
        return counter;
    }

    public synchronized void increment() {
        counter++;
    }

/*    private AtomicInteger counter = new AtomicInteger(0);
    public void increment(){
    	counter.getAndIncrement();
    }
    
    public int value(){
    	return counter.get();
    }*/
}
