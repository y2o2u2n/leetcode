package me.y2o2u2n.p86;

/**
 * Created by JunSeok Youn on 2021-04-19
 */
public class PartitionList {
	public static void main(String[] args) {
		ListNode h1 = new ListNode(1);
		h1.next = new ListNode(4);
		h1.next.next = new ListNode(3);
		h1.next.next.next = new ListNode(2);
		h1.next.next.next.next = new ListNode(5);
		h1.next.next.next.next.next = new ListNode(2);

		printListNode(partition(h1, 3));
	}

	private static ListNode partition(ListNode head, int x) {
		ListNode h1 = new ListNode();
		ListNode h1Current = h1;
		ListNode h2 = new ListNode();
		ListNode h2Current = h2;

		ListNode current = head;
		while(current != null) {
			// System.out.println(current.val);
			if (current.val >= x) {
				h2Current.next = current;
				h2Current = h2Current.next;
			} else {
				h1Current.next = current;
				h1Current = h1Current.next;
			}

			current = current.next;
		}

		h1Current.next = h2.next;
		h2Current.next = null;

		return h1.next;
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

	private static void printListNode(ListNode head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
