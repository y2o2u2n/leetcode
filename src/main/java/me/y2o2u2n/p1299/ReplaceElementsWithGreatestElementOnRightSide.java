package me.y2o2u2n.p1299;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by JunSeok Youn on 2021-06-28
 */
public class ReplaceElementsWithGreatestElementOnRightSide {
	public int[] replaceElements(int[] arr) {
		int length = arr.length;
		int max = -1;

		Deque<Integer> deque = new LinkedList<>();

		for (int i = length - 1; i >= 0 ; i--) {
			max = Math.max(max, arr[i]);
			deque.addFirst(max);
			System.out.println(max);
		}

		deque.pollFirst();
		deque.addLast(-1);

		int[] ans = new int[deque.size()];
		int i = 0;
		while(!deque.isEmpty()) {
			ans[i++] = deque.pollFirst();
		}

		return ans;
	}
}
