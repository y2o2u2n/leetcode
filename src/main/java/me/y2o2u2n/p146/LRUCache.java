package me.y2o2u2n.p146;

import java.util.LinkedHashMap;

/**
 * Created by JunSeok Youn on 2021-03-30
 */
public class LRUCache {
	private LinkedHashMap<Integer, Integer> map;
	private int capacity;

	private LRUCache(int capacity) {
		this.map = new LinkedHashMap<>();
		this.capacity = capacity;
	}

	private int get(int key) {
		if (map.get(key) == null) {
			return -1;
		}

		// add again
		Integer value = map.remove(key);
		map.put(key, value);

		return value;
	}

	private void put(int key, int value) {
		// update if exists
		if (map.get(key) != null) {
			map.remove(key);
			map.put(key, value);
		} else {
			// add
			map.put(key, value);

			// evict LRU if exceeds
			if (map.size() > capacity) {
				Integer evictKey = map.keySet().iterator().next();
				map.remove(evictKey);
			}
		}
	}

	public static void main(String[] args) {
		LRUCache c1 = new LRUCache(2);
		c1.put(1, 1); // cache is {1=1}
		c1.put(2, 2); // cache is {1=1, 2=2}
		System.out.println(c1.get(1));    // return 1
		c1.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		System.out.println(c1.get(2));    // returns -1 (not found)
		c1.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		System.out.println(c1.get(1));    // return -1 (not found)
		System.out.println(c1.get(3));    // return 3
		System.out.println(c1.get(4));    // return 4

		System.out.println();

		LRUCache c2 = new LRUCache(2);
		c2.get(2);
		c2.put(2, 6);
		System.out.println(c2.get(1));
		c2.put(1, 5);
		c2.put(1, 2);
		System.out.println(c2.get(1));
		System.out.println(c2.get(2));

		System.out.println();

		LRUCache c3 = new LRUCache(2);
		c3.put(2, 1);
		c3.put(1, 1);
		c3.put(2, 3);
		c3.put(4, 1);
		System.out.println(c3.get(1));
		System.out.println(c3.get(2));
	}
}
