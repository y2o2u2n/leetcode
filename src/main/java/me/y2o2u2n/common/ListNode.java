package me.y2o2u2n.common;

/**
 * Created by JunSeok Youn on 2021-06-24
 */
public class ListNode {
	public int val;
	public ListNode next;

	public ListNode() {

	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	public static boolean isEqual(ListNode head1, ListNode head2) {
		ListNode current1 = head1;
		ListNode current2 = head2;

		while (current1 != null && current2 != null) {
			if (current1.val != current2.val) {
				return false;
			}

			current1 = current1.next;
			current2 = current2.next;
		}

		return current1 == null && current2 == null;

	}
}
