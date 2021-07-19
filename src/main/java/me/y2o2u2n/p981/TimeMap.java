package me.y2o2u2n.p981;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMap {
	private final Map<String, List<Object[]>> map; // list will be ordered by timestamp ascending

	public TimeMap() {
		map = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		List<Object[]> list = map.getOrDefault(key, new ArrayList<>());
		list.add(new Object[] {value, timestamp});
		map.put(key, list);
	}

	public String get(String key, int timestamp) {
		if (!map.containsKey(key)) {
			return "";
		}

		List<Object[]> list = map.get(key);
		int start = 0;
		int end = list.size() - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			int val = (int)list.get(mid)[1];

			if (val == timestamp) {
				return (String)list.get(mid)[0];
			} else if (val > timestamp) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		if (end < 0) {
			return "";
		}

		return (String)list.get(end)[0];
	}
}

