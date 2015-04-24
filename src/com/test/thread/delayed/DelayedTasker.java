package com.test.thread.delayed;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 抛出异常     特殊值        阻塞      超时 
插入 add(e) offer(e) put(e) offer(e, time, unit) 
移除 remove() poll() take() poll(time, unit) 
检查 element() peek() 不可用 不可用 

 * @author 张超
 * 2012-4-23下午04:54:46
 *
 */
public class DelayedTasker implements Runnable {

	private DelayQueue<DelayedTask> queue = new DelayQueue<DelayedTask>();

	public void addDelayTask(DelayedTask task) {
		queue.put(task);
	}

	public void removeDelayTask() {
		queue.poll();
	}

	public Collection<DelayedTask> getAllDelayedTask() {
		return Collections.unmodifiableCollection(queue);
	}

	public int getTaskQuantity(){
		return queue.size();
	}
	@Override
	public void run() {
		while(!queue.isEmpty()){
			try {
				queue.take().run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Finished DelayedTask!!!!");
	}

	public static class DelayedTask implements Runnable, Delayed {
		private static int count = 0;
		private final  int id = count++;
		private final int delta;
		private final long trigger;// 任务的延迟时间

		public DelayedTask(int delayedInSeconds) {
			delta = delayedInSeconds;
			trigger = System.nanoTime()
					+ TimeUnit.NANOSECONDS.convert(delta, TimeUnit.SECONDS);
		}

		@Override
		public void run() {
			System.out.println(this);
		}

		@Override
		public long getDelay(TimeUnit unit) {
			return unit.convert(trigger - System.nanoTime(),
					TimeUnit.NANOSECONDS);
		}

		@Override
		public int compareTo(Delayed o) {
			DelayedTask task = (DelayedTask) o;
			if (trigger < task.trigger) {
				return -1;
			}
			if (trigger > task.trigger) {
				return 1;
			}
			return 0;
		}

		public String toString() {
			return "[" + delta + "s]" + "Task" + id;
		}
	}
	
	public static void main(String[] args) {
		Random ran = new Random();
		DelayedTasker tasker = new DelayedTasker();
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0;i<8;i++){
			tasker.addDelayTask(new DelayedTask(ran.nextInt(5)));
		}
		exec.execute(tasker);
		exec.shutdown();
	}
}
