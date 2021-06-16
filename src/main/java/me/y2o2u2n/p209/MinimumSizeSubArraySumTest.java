package me.y2o2u2n.p209;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-06-16
 */
class MinimumSizeSubArraySumTest {
	private final MinimumSizeSubArraySum sut = new MinimumSizeSubArraySum();

	@Test
	void case1() {
		assertEquals(2, sut.minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3}));
	}

	@Test
	void case2() {
		assertEquals(1, sut.minSubArrayLen(4, new int[] {1, 4, 4}));
	}

	@Test
	void case3() {
		assertEquals(0, sut.minSubArrayLen(11, new int[] {1, 1, 1, 1, 1, 1, 1, 1}));
	}

	@Test
	void case4() {
		assertEquals(1, sut.minSubArrayLen(7, new int[] {1, 1, 1, 1, 7}));
	}
}