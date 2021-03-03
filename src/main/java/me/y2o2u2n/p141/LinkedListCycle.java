package me.y2o2u2n.p141;

import java.util.HashSet;

/**
 * Created by JunSeok Youn on 2021-03-03
 */
public class LinkedListCycle {
	public static void main(String[] args) {
		ListNode e1n1 = new ListNode(3);
		ListNode e1n2 = new ListNode(2);
		ListNode e1n3 = new ListNode(0);
		ListNode e1n4 = new ListNode(-4);

		e1n1.next = e1n2;
		e1n2.next = e1n3;
		e1n3.next = e1n4;
		e1n4.next = e1n2;

		System.out.println(hasCycle(e1n1));

		ListNode e2n1 = new ListNode(1);
		ListNode e2n2 = new ListNode(2);

		e2n1.next = e2n2;
		e2n2.next = e2n1;

		System.out.println(hasCycle(e2n1));

		ListNode e3n1 = new ListNode(1);

		System.out.println(hasCycle(e3n1));
	}

	private static boolean hasCycle(ListNode head) {
		return s2(head);
	}

	private static boolean s1(ListNode head) {
		HashSet<Integer> set = new HashSet<>();

		ListNode current = head;
		while (current != null) {
			if (set.contains(current.hashCode())) {
				return true;
			} else {
				set.add(current.hashCode());
			}
			current = current.next;
		}

		return false;
	}

	private static boolean s2(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}

		ListNode once = head.next;
		ListNode twice = head.next.next;

		while (once != null && twice != null) {
			if (once == twice) {
				return true;
			}

			if (twice.next == null) {
				return false;
			}

			once = once.next;
			twice = twice.next.next;
		}

		return false;
	}

	private static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
