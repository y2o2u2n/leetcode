package me.y2o2u2n.p1091;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-06-28
 */
class ShortestPathInBinaryMatrixTest {
	private final ShortestPathInBinaryMatrix sut = new ShortestPathInBinaryMatrix();

	@Test
	void case1() {
		assertEquals(
			2,
			sut.shortestPathBinaryMatrix(
				new int[][] {
					{0, 1},
					{1, 0}
				}
			)
		);
	}

	@Test
	void case2() {
		assertEquals(
			4,
			sut.shortestPathBinaryMatrix(
				new int[][]
					{
						{0, 0, 0},
						{1, 1, 0},
						{1, 1, 0}
					}
			)
		);
	}

	@Test
	void case4() {
		assertEquals(
			-1,
			sut.shortestPathBinaryMatrix(
				new int[][]
					{
						{0, 0, 0},
						{1, 1, 0},
						{1, 1, 1}
					}
			)
		);
	}

	@Test
	void case5() {
		assertEquals(
			14,
			sut.shortestPathBinaryMatrix(
				new int[][]
					{
						{0, 1, 1, 0, 0, 0},
						{0, 1, 0, 1, 1, 0},
						{0, 1, 1, 0, 1, 0},
						{0, 0, 0, 1, 1, 0},
						{1, 1, 1, 1, 1, 0},
						{1, 1, 1, 1, 1, 0},
					}
			)
		);
	}

	@Test
	void case6() {
		assertEquals(
			3,
			sut.shortestPathBinaryMatrix(
				new int[][]
					{
						{0, 0, 0},
						{0, 0, 0},
						{0, 0, 0}
					}
			)
		);
	}
}