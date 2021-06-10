package me.y2o2u2n.p1049;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/06/11
 */
class LastStoneWeight2Test {
	private final LastStoneWeight2 sut = new LastStoneWeight2();

	@Test
	void case1() {
		assertEquals(1, sut.lastStoneWeightII(new int[] {2, 7, 4, 1, 8, 1}));
	}

	@Test
	void case2() {
		assertEquals(5, sut.lastStoneWeightII(new int[] {31, 26, 33, 21, 40}));
	}

	@Test
	void case3() {
		assertEquals(1, sut.lastStoneWeightII(new int[] {1, 2}));
	}
}