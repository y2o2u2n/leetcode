package me.y2o2u2n.p82;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import me.y2o2u2n.common.ListNode;

class RemoveDuplicatesFromSortedList2Test {
	private final RemoveDuplicatesFromSortedList2 sut = new RemoveDuplicatesFromSortedList2();

	@Test
	void case1() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next = new ListNode(5);

		ListNode actual = sut.deleteDuplicates(head);

		ListNode expected = new ListNode(1);
		expected.next = new ListNode(2);
		expected.next.next = new ListNode(5);

		assertTrue(ListNode.isEqual(expected, actual));
	}

	@Test
	void case2() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(3);

		ListNode actual = sut.deleteDuplicates(head);

		ListNode expected = new ListNode(2);
		expected.next = new ListNode(3);

		assertTrue(ListNode.isEqual(expected, actual));
	}
}