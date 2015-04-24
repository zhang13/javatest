package com.test.string;

import java.util.Formatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formatter1 {

	public static void main(String[] args) {
		Formatter f = new Formatter(System.out);
		f.format("%d %s\n", 5,"sss");
		StringBuffer result=new StringBuffer("");
		for(int i=0;i<10;i++){
			result.append(f.format("%x ", 17));
		}
		String knights="Then, when you have found the shrubbery, you must be good.";
		System.out.println(knights.split("you|the"));
		System.out.println("Ax-x。".matches("[A-Z].*。"));
		
		Matcher m = Pattern.compile(".+").matcher("帅是一种态度！");
		while(m.find()){
			System.out.print(m.group()+" ");
		}
		System.out.println();
		int i=0;
		while(m.find(i)){
			System.out.print(m.group()+" ");
			i++;
		}
	}
}
