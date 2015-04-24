package com.test.collections;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("a", 1);
		for(int i=0;i<3;i++){
			map.put("a", 1+map.get("a"));
		}
		System.out.println(map.get("a"));
	}

}
