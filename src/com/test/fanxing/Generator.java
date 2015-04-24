package com.test.fanxing;

import java.util.Iterator;


public class Generator implements Iterable<Integer>{

	private int count;
	
	public Generator(int count) {
		this.count = count;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {

			@Override
			public boolean hasNext() {
				
				return count>0;
			}

			@Override
			public Integer next() {
				return fib(count--);
			}
			
			private int fib(int n){
				if(n<2)return 1;
				return fib(n-2) + fib(n-1);
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
				
			}
		};
	}

	public static void main(String[] args) {
		Iterator<Integer> it =new Generator(8).iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
}
