package me.y2o2u2n.p148;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by JunSeok Youn on 2021-03-30
 */
public class SortList {

	public static void main(String[] args) {
		ListNode e1 = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
		printListNode(sortList(e1));

		ListNode e2 = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))));
		printListNode(sortList(e2));
	}

	// private static ListNode sortList(ListNode head) {
	// 	if (head == null || head.next == null) {
	// 		return head;
	// 	}
	//
	// 	ListNode mid = getMid(head);
	// 	ListNode left = sortList(head);
	// 	ListNode right = sortList(mid);
	//
	// 	return merge(left, right);
	// }
	//
	// private static ListNode merge(ListNode left, ListNode right) {
	// 	ListNode retHead = new ListNode();
	// 	ListNode retTail = retHead;
	//
	// 	while (left != null && right != null) {
	// 		if (left.val < right.val) {
	// 			retTail.next = left;
	// 			retTail = retTail.next;
	// 			left = left.next;
	// 		} else {
	// 			retTail.next = right;
	// 			retTail = retTail.next;
	// 			right = right.next;
	// 		}
	// 	}
	//
	// 	retTail.next = left != null ? left : right;
	//
	// 	return retHead.next;
	// }
	//
	// private static ListNode getMid(ListNode head) {
	// 	ListNode midPrev = null;
	// 	while (head != null && head.next != null) {
	// 		midPrev = (midPrev == null) ? head : midPrev.next;
	// 		head = head.next.next;
	// 	}
	// 	ListNode mid = midPrev.next;
	// 	midPrev.next = null;
	// 	return mid;
	// }

	private static ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		int length = length(head);
		Map<Integer, ListNode> map = getMap(head);
		return sort(0, length - 1, map);
	}

	private static Map<Integer, ListNode> getMap(ListNode head) {
		Map<Integer, ListNode> map = new HashMap<>();

		int i = 0;
		ListNode current = head;
		while (current != null) {
			map.put(i, current);
			i++;
			current = current.next;
		}

		return map;
	}

	// O(nlogn)
	private static ListNode sort(int start, int end, Map<Integer, ListNode> map) {
		if (start == end) {
			return map.get(start);
		}

		int mid = (start + end) / 2;

		int p = start;
		int q = mid + 1;
		ListNode pNode = sort(start, mid, map);
		ListNode qNode = sort(mid + 1, end, map);

		ListNode ret = new ListNode();
		ListNode retHead = ret;

		while (pNode != null && p <= mid && qNode != null && q <= end) {
			if (pNode.val < qNode.val) {
				ListNode node = new ListNode(pNode.val);
				ret.next = node;
				ret = ret.next;
				pNode = pNode.next;
				p++;
			} else {
				ListNode node = new ListNode(qNode.val);
				ret.next = node;
				ret = ret.next;
				qNode = qNode.next;
				q++;
			}
		}

		while (pNode != null && p <= mid) {
			ret.next = new ListNode(pNode.val);
			ret = ret.next;
			pNode = pNode.next;
			p++;
		}

		while (qNode != null && q <= end) {
			ret.next = new ListNode(qNode.val);
			ret = ret.next;
			qNode = qNode.next;
			q++;
		}

		return retHead.next;
	}

	// O(n)
	private static int length(ListNode head) {
		int i = 0;
		ListNode current = head;
		while (current != null) {
			i++;
			current = current.next;
		}

		return i;
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
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}
}
