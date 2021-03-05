package me.y2o2u2n.p160;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JunSeok Youn on 2021-03-05
 */
public class IntersectionOfTowLinkedLists {
	public static void main(String[] args) {
		ListNode c1 = new ListNode(8, new ListNode(4, new ListNode(5)));
		ListNode a1 = new ListNode(4, new ListNode(1, c1));
		ListNode b1 = new ListNode(5, new ListNode(6, new ListNode(1, c1)));
		System.out.println(getIntersectionNode(a1, b1).val);
	}

	private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode intersection = null;

		Set<ListNode> setA = new HashSet<>();
		ListNode currentA = headA;

		while (currentA != null) {
			setA.add(currentA);
			currentA = currentA.next;
		}

		ListNode currentB = headB;
		while (currentB != null) {
			if (setA.contains(currentB)) {
				intersection = currentB;
				break;
			}
			currentB = currentB.next;
		}

		return intersection;
	}

	private static class ListNode {
		private int val;
		private ListNode next;

		ListNode(int x) {
			this.val = x;
			this.next = null;
		}

		ListNode(int x, ListNode next) {
			this.val = x;
			this.next = next;
		}
	}

}
