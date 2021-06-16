package me.y2o2u2n.p1752;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-06-16
 */
class CheckIfArrayIsSortedAndRotatedTest {
	private final CheckIfArrayIsSortedAndRotated sut = new CheckIfArrayIsSortedAndRotated();

	@Test
	void case1() {
		assertTrue(sut.check(new int[] {3, 4, 5, 1, 2}));
	}

	@Test
	void case2() {
		assertFalse(sut.check(new int[] {2, 1, 3, 4}));
	}
}