package me.y2o2u2n.p1218;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-05-26
 */
class LongestArithmeticSubsequenceOfGivenDifferenceTest {

	@Test
	void longestSubsequence() {
		LongestArithmeticSubsequenceOfGivenDifference sut = new LongestArithmeticSubsequenceOfGivenDifference();

		assertEquals(4, sut.longestSubsequence(new int[] {1, 2, 3, 4}, 1));
		assertEquals(1, sut.longestSubsequence(new int[] {1, 3, 5, 7}, 1));
		assertEquals(4, sut.longestSubsequence(new int[] {1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));
		assertEquals(2, sut.longestSubsequence(new int[] {4, 12, 10, 0, -2, 7, -8, 9, -9, -12, -12, 8, 8}, 0));
		assertEquals(2, sut.longestSubsequence(new int[] {3, 0, -3, 4, -4, 7, 6}, 3));
		assertEquals(2, sut.longestSubsequence(new int[] {10, -11, 8, -1, -14, -5, 7, 15, 7, -2, 14, 5, -3, -9, 12, -9}, -2));
	}
}