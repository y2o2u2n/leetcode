package me.y2o2u2n.p1749;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MaximumAbsoluteSumOfAnySubarrayTest {
	private final MaximumAbsoluteSumOfAnySubarray sut = new MaximumAbsoluteSumOfAnySubarray();

	@Test
	void case1() {
		assertEquals(5, sut.maxAbsoluteSum(new int[] {1, -3, 2, 3, -4}));
	}

	@Test
	void case2() {
		assertEquals(8, sut.maxAbsoluteSum(new int[] {2, -5, 1, -4, 3, -2}));
	}
}