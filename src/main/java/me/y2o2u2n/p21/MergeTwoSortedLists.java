package me.y2o2u2n.p21;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
		ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

		ListNode merged = solve(l1, l2);
		while (merged != null) {
			System.out.println(merged.val);
			merged = merged.next;
		}
	}

	private static ListNode solve(ListNode l1, ListNode l2) {
		ListNode start = new ListNode();
		ListNode current = start;

		while(l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				current.next = new ListNode(l1.val);
				current = current.next;
				l1 = l1.next;
			} else {
				current.next = new ListNode(l2.val);
				current = current.next;
				l2 = l2.next;
			}
		}

		while (l1 != null) {
			current.next = new ListNode(l1.val);
			current = current.next;
			l1 = l1.next;
		}

		while (l2 != null) {
			current.next = new ListNode(l2.val);
			current = current.next;
			l2 = l2.next;
		}

		return start.next;
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
