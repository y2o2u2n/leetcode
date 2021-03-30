package me.y2o2u2n.p142;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by JunSeok Youn on 2021-03-30
 */
public class LinkedListCycle2 {
	public static void main(String[] args) {
		ListNode c1n1 = new ListNode(3);
		ListNode c1n2 = new ListNode(2);
		ListNode c1n3 = new ListNode(0);
		ListNode c1n4 = new ListNode(-4);

		c1n1.next = c1n2;
		c1n2.next = c1n3;
		c1n3.next = c1n4;
		c1n4.next = c1n2;

		System.out.println(detectCycle(c1n1).val);

		ListNode c2n1 = new ListNode(1);
		ListNode c2n2 = new ListNode(2);

		c2n1.next = c2n2;
		c2n2.next = c2n1;

		System.out.println(detectCycle(c2n1).val);

		ListNode c3n1 = new ListNode(1);

		System.out.println(detectCycle(c3n1));
	}

	private static ListNode detectCycle(ListNode head) {
		return s2(head);
	}

	private static ListNode s1(ListNode head) {
		if (head == null) {
			return null;
		}

		Set<ListNode> set = new HashSet<>();

		ListNode current = head;

		while (current.next != null) {
			if (set.contains(current)) {
				return current;
			}

			set.add(current);

			current = current.next;
		}

		return null;
	}

	private static ListNode s2(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}

		ListNode walker = head;
		ListNode runner = head;

		while (runner != null && runner.next != null) {
			walker = walker.next;
			runner = runner.next.next;

			if (walker == runner) {
				break;
			}
		}

		if (runner == null || runner.next == null) {
			return null;
		}


		ListNode seeker = head;
		while (seeker != walker) {
			walker = walker.next;
			seeker = seeker.next;
		}

		return seeker;
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
