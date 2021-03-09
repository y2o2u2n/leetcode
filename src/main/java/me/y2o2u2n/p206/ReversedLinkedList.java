package me.y2o2u2n.p206;

/**
 * Created by JunSeok Youn on 2021-03-09
 */
public class ReversedLinkedList {

	public static void main(String[] args) {
		ListNode h1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		printNode(reverseList(h1));
	}

	private static ListNode reverseList(ListNode head) {
		ListNode current = head;
		ListNode tail = null;

		while(current != null) {
			ListNode next = current.next;
			current.next = tail;
			tail = current;
			current = next;
		}

		return tail;
	}

	private static void printNode(ListNode head) {
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
		}
		System.out.println();
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
