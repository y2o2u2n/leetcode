package me.y2o2u2n.p1752;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by JunSeok Youn on 2021-06-16
 */
public class CheckIfArrayIsSortedAndRotated {
	public boolean check(int[] nums) {
		int length = nums.length;

		Queue<Integer> queue = new LinkedList<>();
		for (int num : nums) {
			queue.offer(num);
		}

		int i = length;
		while (i-- > 0) {
			if (isMonotoneIncreasing(queue)) {
				return true;
			}

			queue.offer(queue.poll());
		}

		return false;
	}

	private boolean isMonotoneIncreasing(Queue<Integer> queue) {
		List<Integer> list = new ArrayList<>(queue);

		int prev = list.get(0);

		for (int i = 1; i < list.size(); i++) {
			Integer current = list.get(i);
			if (prev > current) {
				return false;
			}

			prev = current;
		}

		return true;
	}
}
