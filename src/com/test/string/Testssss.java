package com.test.string;

public class Testssss {

	public static void main(String[] args) {
		char a =1;
		String resultBinaryString = Integer.toBinaryString(a);
		
		while(resultBinaryString.length()<2){
			resultBinaryString="0"+resultBinaryString;//补齐得到的2进制8字节数前边的0，例如1,补齐为01
		}
		System.out.println(resultBinaryString);
	}

}
