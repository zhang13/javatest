package example;

import java.util.concurrent.atomic.AtomicBoolean;

import org.junit.Assert;
import org.junit.Test;

/**
 * 测试线程是否真的阻塞
 */
public class TestBlockingBehavior {

	AtomicBoolean blocked = new AtomicBoolean(true);
	BlackMarket bm;
	@Test
    public void testBlockingBehavior() throws Exception {
        Thread buyer = new Thread() {
            @Override
            public void run() {
                try {
                	bm=new BlackMarket();
                	bm.buyTicket();
                	
                    blocked.set(false);
                    System.out.println("continue");
                    Assert.assertFalse("Method didn't block!", blocked.get());
                } catch (InterruptedException success) {
                	/**
                	 * 需要注意的是，InterruptedException是线程自己从内部抛出的，
                	 * 并不是interrupt()方法抛出的。对某一线程调用interrupt()时，
                	 * 如果该线程正在执行普通的代码，那么该线程根本就不会抛出InterruptedException。
                	 * 但是，一旦该线程进入到wait()/sleep()/join()后，就会立刻抛出InterruptedException。 
                	 */
                	blocked.set(false);
                	System.out.println("exception"+success.getMessage());
                }
            }
        };
        buyer.start();
        Thread.sleep(1000);
        //buyer.join(1000);
        //buyer.interrupt();
        Assert.assertTrue("Thread didn't interrupt!", buyer
                .isAlive());
        Assert.assertTrue("Method didn't block!", blocked.get());
        
        bm.setBlock(false);
        
    }

	class BlackMarket{
		private boolean blocked=true;
		private synchronized void buyTicket() throws InterruptedException{
			while(blocked){
				System.out.println("wait");
				wait();
			}
		}
		private synchronized void setBlock(boolean blocked){
			this.blocked=blocked;
			notify();
		}
	}
	
}
