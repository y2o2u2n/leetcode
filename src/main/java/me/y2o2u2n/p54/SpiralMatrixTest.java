package me.y2o2u2n.p54;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-06-22
 */
class SpiralMatrixTest {
	private final SpiralMatrix sut = new SpiralMatrix();

	@Test
	void case1() {
		assertEquals(
			List.of(1, 2, 3, 6, 9, 8, 7, 4, 5),
			sut.spiralOrder(
				new int[][] {
					{1, 2, 3},
					{4, 5, 6},
					{7, 8, 9}
				}
			)
		);
	}

	@Test
	void case2() {
		assertEquals(
			List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7),
			sut.spiralOrder(
				new int[][] {
					{1, 2, 3, 4},
					{5, 6, 7, 8},
					{9, 10, 11, 12}
				}
			)
		);
	}

}