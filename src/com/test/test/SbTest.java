package com.test.test;

public class SbTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int size=2;
		StringBuffer sb = new StringBuffer();
		for(int i =0;i<size;i++){
			sb.append("dddd");
			sb.append("¡¢");
			if(i==size-1){
				sb.replace(sb.length()-1, sb.length(), "");
			}
			if(i>=3){
				sb.replace(sb.length()-1, sb.length(), "");
				sb.append("µÈ");
				sb.append(size);
				sb.append("¸ö£¬");
				break;
			}
		}
		System.out.println(sb.toString());
	}

}
