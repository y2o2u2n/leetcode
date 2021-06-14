package me.y2o2u2n.p189;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by JunSeok Youn on 2021/06/15
 */
public class RotateArray {
	public void rotate(int[] nums, int k) {
		Deque<Integer> deque = new LinkedList<>();
		for (int num : nums) {
			deque.offer(num);
		}

		while (k-- > 0) {
			Integer poll = deque.pollLast();
			deque.offerFirst(poll);
		}

		int i = 0;
		while (!deque.isEmpty()) {
			Integer poll = deque.poll();
			nums[i] = poll;
			i++;
		}
	}
}
