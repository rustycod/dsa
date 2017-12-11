package org.sample.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapPut {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		map.put(2,3);
		map.put(map.put(4,5), 6);
		
		for(Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
}
