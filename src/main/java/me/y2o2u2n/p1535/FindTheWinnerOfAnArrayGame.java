package me.y2o2u2n.p1535;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by JunSeok Youn on 2021/06/08
 */
public class FindTheWinnerOfAnArrayGame {
	public int getWinner(int[] arr, int k) {
		return s2(arr, k);
	}

	private int s2(int[] arr, int k) {
		Deque<Integer> deque = new LinkedList<>();
		for (int val : arr) {
			deque.offer(val);
		}

		Map<Integer, Integer> winCountByNum = new HashMap<>();

		int roundCount = 0;

		while (true) {
			int first = deque.pollFirst();
			int second = deque.pollFirst();

			if (first > second) {
				int count = winCountByNum.getOrDefault(first, 0);
				winCountByNum.put(first, count + 1);
				winCountByNum.put(second, 0);

				deque.addFirst(first);
				deque.addLast(second);
			} else {
				int count = winCountByNum.getOrDefault(second, 0);
				winCountByNum.put(second, count + 1);
				winCountByNum.put(first, 0);

				deque.addFirst(second);
				deque.addLast(first);
			}

			if (winCountByNum.getOrDefault(first, 0) >= k
				|| winCountByNum.getOrDefault(second, 0) >= k) {
				break;
			}

			roundCount++;

			if (roundCount >= arr.length) {
				break;
			}
		}

		return deque.pollFirst();
	}

	// Time Limit Exceeded
	private Integer s1(int[] arr, int k) {
		Deque<Integer> deque = new LinkedList<>();
		for (int val : arr) {
			deque.offer(val);
		}

		Map<Integer, Integer> winCountByNum = new HashMap<>();

		while (true) {
			int first = deque.pollFirst();
			int second = deque.pollFirst();

			if (first > second) {
				int count = winCountByNum.getOrDefault(first, 0);
				winCountByNum.put(first, count + 1);
				winCountByNum.put(second, 0);

				deque.addFirst(first);
				deque.addLast(second);
			} else {
				int count = winCountByNum.getOrDefault(second, 0);
				winCountByNum.put(second, count + 1);
				winCountByNum.put(first, 0);

				deque.addFirst(second);
				deque.addLast(first);
			}

			if (winCountByNum.getOrDefault(first, 0) >= k
				|| winCountByNum.getOrDefault(second, 0) >= k) {
				break;
			}
		}

		return deque.pollFirst();
	}
}
