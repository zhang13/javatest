package com.test;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class typechange {

	public static void main(String[] args) {
		String tempStr = "1601";
		String a = tempStr.substring(0, 2);
		String b = tempStr.substring(2, 4);
		
		Formatter f = new Formatter();
		f.format("%x", Integer.parseInt(a));
		System.out.println(Byte.valueOf(Integer.toHexString(Integer.parseInt(a))));
		
		byte x = Byte.valueOf(a);
		byte y = Byte.valueOf(Integer.toHexString(Integer.parseInt(b)));
		//byte address1=Integer.toHexString(Integer.parseInt(a));
		
		byte[] command = new byte[] { 0x16, 0x16, 0x02, 0x10, 0x01,0x01, 0x00, 0x11,0x03, 0x26, 0x00 };
		
		String commandStr = "16 16 02 10 01 01 00 11 03 26 00";//16进制的字符串形势
		
		System.out.println(HexString2Bytes(commandStr.replace(" ", "")));//转换后应该是0xXX形式，但是显示的时候，自动转换成10进制显示了。！！！
		int sum = 0;
		for(int i =3;i<command.length-2;i++){
			sum+=command[i];
		}
		System.out.println(sum);
		System.out.println(Integer.parseInt(String.valueOf(0x26), 10));
		//System.out.println(Integer.parseInt(tempStr, 16));
		
		System.out.println(Integer.toHexString(72));
		System.out.println(Integer.parseInt("61", 16));
		System.out.println(Integer.parseInt("12224", 16));
		System.out.println(Integer.toHexString(2022));
		System.out.println("ssssssssss"+Math.round(5/2));
		
		byte[] ab={00, 00, 00, 00, 00,06, 01, 02, 00, 02};
		String checkStr = Integer.toBinaryString( ab[9]);
		System.out.println(checkStr);
		System.out.println(checkStr.length());
		while(checkStr.length()<3){
			checkStr="0"+checkStr;
		}
		System.out.println(checkStr);
		if(checkStr.charAt(1)=='1'){
			System.out.println(true);
		}
	}
	
	/** 
	* 将指定字符串src，以每两个字符分割转换为16进制形式 
	* 如："2B44EFD9" --> byte[]{0x2B, 0x44, 0xEF, 0xD9} 
	* @param src String 
	* @return byte[] 
	*/ 
	public static byte[] HexString2Bytes(String src){ 
		byte[] ret = new byte[11]; 
		byte[] tmp = src.getBytes(); 
		for(int i=0; i<11; i++){ 
		ret[i] = uniteBytes(tmp[i*2], tmp[i*2+1]); 
		} 
		return ret; 
	} 
	
	/** 
	* 将两个ASCII字符合成一个字节； 
	* 如："EF"--> 0xEF 
	* @param src0 byte 
	* @param src1 byte 
	* @return byte 
	*/ 
	public static byte uniteBytes(byte src0, byte src1) { 
		byte _b0 = Byte.decode("0x" + new String(new byte[]{src0})).byteValue(); 
		_b0 = (byte)(_b0 << 4); 
		byte _b1 = Byte.decode("0x" + new String(new byte[]{src1})).byteValue(); 
		byte ret = (byte)(_b0 ^ _b1); 
		return ret; 
	}
	
	private static String format(byte[] data){
		StringBuilder result = new StringBuilder();
		int n=0;
		for(byte b:data){
			if(n%16==0)
				result.append(String.format("%05X: ", n));
			result.append(String.format("%02X: ", b));
			n++;
			if(n%16==0)result.append("\n");
		}
		result.append("\n");
		return result.toString();
	}
	
}
