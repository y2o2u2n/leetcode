package me.y2o2u2n.p1679;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/06/09
 */
class MaxNumberOfKSumPairsTest {
	private final MaxNumberOfKSumPairs sut = new MaxNumberOfKSumPairs();

	@Test
	void case1() {
		assertEquals(2, sut.maxOperations(new int[] {1, 2, 3, 4}, 5));
	}

	@Test
	void case2() {
		assertEquals(1, sut.maxOperations(new int[] {3, 1, 3, 4, 3}, 6));
	}

	@Test
	void case3() {
		assertEquals(0, sut.maxOperations(new int[] {3, 5, 1, 5}, 2));
	}

	@Test
	void case4() {
		assertEquals(2, sut.maxOperations(new int[] {4, 4, 1, 3, 1, 3, 2, 2, 5, 5, 1, 5, 2, 1, 2, 3, 5, 4}, 2));
	}
}