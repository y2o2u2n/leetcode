package me.y2o2u2n.p19;

/**
 * Created by JunSeok Youn on 2021-03-02
 */
public class RemoveNthNodeFromEndOfList {
	public static void main(String[] args) {
		printListNode(removeNthFromEnd(
			new ListNode(1,
				new ListNode(2,
					new ListNode(3,
						new ListNode(4,
							new ListNode(5)))))
			, 2));

		printListNode(removeNthFromEnd(
			new ListNode(1)
			, 1));

		printListNode(removeNthFromEnd(
			new ListNode(1,
				new ListNode(2))
			, 1));

		printListNode(removeNthFromEnd(
			new ListNode(1,
				new ListNode(2))
			, 2));
	}

	private static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode current = head;
		int length = 0;
		while (current != null) {
			length++;
			current = current.next;
		}

		int currentIndex = 0;
		int targetIndex = length - n;

		if (targetIndex == 0) {
			return head.next;
		}

		current = head;
		while (current != null) {
			if (currentIndex == targetIndex - 1) {
				current.next = current.next.next;
			}

			currentIndex++;
			current = current.next;
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

	private static void printListNode(ListNode head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}





