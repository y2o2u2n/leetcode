package me.y2o2u2n.p83;

/**
 * Created by JunSeok Youn on 2021-02-26
 */
public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		printNode(deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2)))));
		printNode(deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))))));
		printNode(deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(1)))));
	}

	private static ListNode deleteDuplicates(ListNode head) {
		ListNode current = head;
		ListNode next;
		while (current != null) {
			next = current.next;
			if (next == null) {
				break;
			}

			if (current.val == next.val) {
				current.next = next.next;
			} else {
				current = current.next;
			}
		}

		return head;
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

	private static void printNode(ListNode head) {
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
		}
		System.out.println();
	}
}
