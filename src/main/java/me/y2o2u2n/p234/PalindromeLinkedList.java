package me.y2o2u2n.p234;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JunSeok Youn on 2021-03-10
 */
public class PalindromeLinkedList {

	public static void main(String[] args) {
		ListNode h1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
		ListNode h2 = new ListNode(1, new ListNode(2));
		System.out.println(isPalindrome(h1));
		System.out.println(isPalindrome(h2));
	}

	private static boolean isPalindrome(ListNode head) {
		return s2(head);
	}

	private static boolean s1(ListNode head) {
		List<Integer> list = new ArrayList<>();

		ListNode current = head;
		while (current != null) {
			list.add(current.val);
			current = current.next;
		}

		int length = list.size();
		boolean ret = true;
		for (int i = 0; i < length / 2; i++) {
			if (!list.get(i).equals(list.get(length - 1 - i))) {
				ret = false;
			}
		}

		return ret;
	}

	private static boolean s2(ListNode head) {
		ListNode tail = null;
		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			ListNode next = slow.next;
			slow.next = tail;
			tail = slow;
			slow = next;
		}

		if (fast != null) {
			slow = slow.next;
		}

		while (tail != null) {
			if (tail.val != slow.val) {
				return false;
			}

			tail = tail.next;
			slow = slow.next;
		}

		return true;
	}

	private static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

}
