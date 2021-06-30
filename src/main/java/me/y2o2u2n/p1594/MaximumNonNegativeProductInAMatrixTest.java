package me.y2o2u2n.p1594;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/06/30
 */
class MaximumNonNegativeProductInAMatrixTest {
	private final MaximumNonNegativeProductInAMatrix sut = new MaximumNonNegativeProductInAMatrix();

	@Test
	void case1() {
		assertEquals(
			-1,
			sut.maxProductPath(
				new int[][] {
					{-1, -2, -3},
					{-2, -3, -3},
					{-3, -3, -2}
				}
			));
	}

	@Test
	void case2() {
		assertEquals(
			8,
			sut.maxProductPath(
				new int[][] {
					{1, -2, 1},
					{1, -2, 1},
					{3, -4, 1}
				}
			));
	}

	@Test
	void case4() {
		assertEquals(
			2,
			sut.maxProductPath(
				new int[][] {
					{1, 4, 4, 0},
					{-2, 0, 0, 1},
					{1, -1, 1, 1}
				}
			));
	}

	@Test
	void case5() {
		assertEquals(
			768,
			sut.maxProductPath(
				new int[][] {
					{-1, -4, 2},
					{4, 3, -1},
					{2, -4, 4},
					{1, -1, -4}
				}
			));
	}
}