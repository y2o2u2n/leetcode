package me.y2o2u2n.p455;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AssignCookiesTest {
	private final AssignCookies sut = new AssignCookies();

	@Test
	void case1() {
		assertEquals(1, sut.findContentChildren(new int[] {1, 2, 3}, new int[] {1, 1}));
	}

	@Test
	void case2() {
		assertEquals(2, sut.findContentChildren(new int[] {1, 2}, new int[] {1, 2, 3}));
	}
}