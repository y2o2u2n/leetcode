package me.y2o2u2n.p1019;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import me.y2o2u2n.common.ListNode;

/**
 * Created by JunSeok Youn on 2021-06-24
 */
class NextGreaterNodeInLinkedListTest {
	private final NextGreaterNodeInLinkedList sut = new NextGreaterNodeInLinkedList();

	@Test
	void case1() {
		ListNode head = new ListNode(2);
		head.next = new ListNode(1);
		head.next.next = new ListNode(5);

		assertArrayEquals(new int[] {5, 5, 0}, sut.nextLargerNodes(head));
	}

	@Test
	void case2() {
		ListNode head = new ListNode(2);
		head.next = new ListNode(7);
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(5);

		assertArrayEquals(new int[] {7, 0, 5, 5, 0}, sut.nextLargerNodes(head));
	}

	@Test
	void case3() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(7);
		head.next.next = new ListNode(5);
		head.next.next.next = new ListNode(1);
		head.next.next.next.next = new ListNode(9);
		head.next.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next.next.next = new ListNode(1);

		assertArrayEquals(new int[] {7, 9, 9, 9, 0, 5, 0, 0}, sut.nextLargerNodes(head));
	}

}