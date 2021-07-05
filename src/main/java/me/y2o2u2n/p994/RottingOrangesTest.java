package me.y2o2u2n.p994;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RottingOrangesTest {
	private final RottingOranges sut = new RottingOranges();

	@Test
	void case1() {
		assertEquals(
			4,
			sut.orangesRotting(
				new int[][] {
					{2, 1, 1},
					{1, 1, 0},
					{0, 1, 1}
				}
			)
		);
	}

	@Test
	void case2() {
		assertEquals(
			-1,
			sut.orangesRotting(
				new int[][] {
					{2, 1, 1},
					{0, 1, 1},
					{1, 0, 1}
				}
			)
		);
	}

	@Test
	void case3() {
		assertEquals(
			0,
			sut.orangesRotting(
				new int[][] {
					{0}
				}
			)
		);
	}

}