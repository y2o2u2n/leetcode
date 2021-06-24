package me.y2o2u2n.p1019;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import me.y2o2u2n.common.ListNode;

/**
 * Created by JunSeok Youn on 2021-06-24
 */
public class NextGreaterNodeInLinkedList {
	public int[] nextLargerNodes(ListNode head) {
		List<Integer> nums = new ArrayList<>();

		ListNode current = head;
		while (current != null) {
			nums.add(current.val);
			current = current.next;
		}

		int[] ans = new int[nums.size()];

		PriorityQueue<Item> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
		for (int i = 0; i < nums.size(); i++) {
			int num = nums.get(i);

			if (pq.isEmpty()) {
				pq.offer(new Item(i, num));
			} else {
				while (!pq.isEmpty() && pq.peek().value < num) {
					Item poll = pq.poll();
					ans[poll.index] = num;
				}

				pq.offer(new Item(i, num));
			}
		}

		return ans;
	}

	private class Item {
		int index;
		int value;

		private Item(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
}
