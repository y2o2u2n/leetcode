package me.y2o2u2n.p1493;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/07/02
 */
class LongestSubarrayOfOnesAfterDeletingOneElementTest {
	private final LongestSubarrayOfOnesAfterDeletingOneElement sut = new LongestSubarrayOfOnesAfterDeletingOneElement();

	@Test
	void case1() {
		assertEquals(3, sut.longestSubarray(new int[] {1, 1, 0, 1}));
	}

	@Test
	void case2() {
		assertEquals(5, sut.longestSubarray(new int[] {0, 1, 1, 1, 0, 1, 1, 0, 1}));
	}

	@Test
	void case3() {
		assertEquals(2, sut.longestSubarray(new int[] {1,1,1}));
	}

	@Test
	void case4() {
		assertEquals(4, sut.longestSubarray(new int[] {1,1,0,0,1,1,1,0,1}));
	}

	@Test
	void case5() {
		assertEquals(0, sut.longestSubarray(new int[] {0,0,0}));
	}
}