package me.y2o2u2n.p542;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/06/15
 */
class ZeroOneMatrixTest {
	private final ZeroOneMatrix sut = new ZeroOneMatrix();

	@Test
	void case1() {
		int[][] actual = sut.updateMatrix(new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
		int[][] expected = new int[][] {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

		for (int i = 0; i < actual.length; i++) {
			assertArrayEquals(expected[i], actual[i]);
		}
	}

	@Test
	void case2() {
		int[][] actual = sut.updateMatrix(new int[][] {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});
		int[][] expected = new int[][] {{0, 0, 0}, {0, 1, 0}, {1, 2, 1}};

		for (int i = 0; i < actual.length; i++) {
			assertArrayEquals(expected[i], actual[i]);
		}
	}

	@Test
	void case3() {
		int[][] actual = sut.updateMatrix(
			new int[][] {
				{1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
				{0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
				{0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
				{1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
				{0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
				{0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
				{0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
				{1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
				{1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
				{1, 1, 1, 1, 0, 1, 0, 0, 1, 1}
			}
		);

		int[][] expected = new int[][] {
			{1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
			{0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
			{0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
			{1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
			{0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
			{0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
			{0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
			{1, 0, 0, 0, 1, 2, 1, 1, 0, 1},
			{2, 1, 1, 1, 1, 2, 1, 0, 1, 0},
			{3, 2, 2, 1, 0, 1, 0, 0, 1, 1}
		};

		for (int i = 0; i < actual.length; i++) {
			assertArrayEquals(expected[i], actual[i]);
		}
	}
}