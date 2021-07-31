package me.y2o2u2n.woowa.task3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by JunSeok Youn on 2021/07/31
 */
public class Task3 {
	public int solution(int[] A) {
		List<Integer> descList = toDescList(A);
		Map<Integer, Boolean> existMap = toExistMap(A);

		for (int number : descList) {
			int oppositeNumber = -number;
			if (existMap.containsKey(oppositeNumber)) {
				return number;
			}
		}

		return 0;
	}

	private List<Integer> toDescList(int[] numbers) {
		List<Integer> numberList = new ArrayList<>();

		for (int number : numbers) {
			numberList.add(number);
		}

		numberList.sort(Comparator.reverseOrder());
		return numberList;
	}

	private Map<Integer, Boolean> toExistMap(int[] numbers) {
		Map<Integer, Boolean> existMap = new HashMap<>();

		for (int number : numbers) {
			existMap.put(number, true);
		}

		return existMap;
	}
}
