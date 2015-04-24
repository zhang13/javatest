package com.test.iftest;

import com.test.comparable.PersonT;

public class IfTest {

	public static void main(String[] args) {
		
	}
	
	public void test1(PersonT p){
		if(p!=null){
			if(p.getName()!=null){
				if("charles".equals(p.getName())){
					System.out.println(p.getName());
				}
			}
		}
	}
	
	public void test(PersonT p){
		if(p==null){
			return;
		}
		if(p.getName()==null){
			return;
		}
		if("charles".equals(p.getName())){
			System.out.println(p.getName());
		}
	}
}
