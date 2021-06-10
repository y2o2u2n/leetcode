package me.y2o2u2n.p1049;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by JunSeok Youn on 2021/06/11
 */
public class LastStoneWeight2 {
	public int lastStoneWeightII(int[] stones) {
		return s2(stones);
	}

	private int s2(int[] stones) {
		Set<Integer> set = new HashSet<>();
		set.add(stones[0]);
		set.add(-stones[0]);

		for (int i = 1; i < stones.length; i++) {
			Set<Integer> newSet = new HashSet<>();

			for (int element : set) {
				newSet.add(element + stones[i]);
				newSet.add(element - stones[i]);
			}

			set = newSet;
		}

		int min = Integer.MAX_VALUE;

		for (Integer element : set) {
			min = Math.min(min, Math.abs(element));
		}

		return min;
	}

	// Wrong Answer
	private Integer s1(int[] stones) {
		List<Integer> stoneList = new ArrayList<>();
		for (int stone : stones) {
			stoneList.add(stone);
		}

		stoneList.sort(Collections.reverseOrder());

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		pq.addAll(stoneList);

		while (pq.size() >= 2) {
			int first = pq.poll();
			int second = pq.poll();

			if (first != second) {
				pq.offer(first - second);
			}
		}

		return pq.poll();
	}
}
