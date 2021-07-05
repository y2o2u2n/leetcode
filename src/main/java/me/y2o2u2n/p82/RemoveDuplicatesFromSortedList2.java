package me.y2o2u2n.p82;

import java.util.HashMap;
import java.util.Map;

import me.y2o2u2n.common.ListNode;

public class RemoveDuplicatesFromSortedList2 {
	public ListNode deleteDuplicates(ListNode head) {
		Map<Integer, Integer> countByNumber = new HashMap<>();

		ListNode current = head;
		while (current != null) {
			int number = current.val;
			Integer count = countByNumber.getOrDefault(number, 0);
			countByNumber.put(number, count + 1);
			current = current.next;
		}

		ListNode ans = new ListNode();
		ListNode ansCurrent = ans;
		current = head;

		while (current != null) {
			int number = current.val;
			Integer count = countByNumber.getOrDefault(number, 0);
			if (count == 1) {
				ansCurrent.next = new ListNode(number);
				ansCurrent = ansCurrent.next;
			}

			current = current.next;
		}

		return ans.next;
	}
}
