package com.test.exception;

public class ExceptionTest {

	private int test(){
		try{
			int i =1/0;
		}catch(Exception e){
			throw new RuntimeException("xxxx");
		}finally{
			
		}
		return 4;
	}
	
	public static void main(String[] args) {
		int i =0;
		try{
			i= new ExceptionTest().test();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(i);
		
	}
	
	
	
}
