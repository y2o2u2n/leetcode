package me.y2o2u2n.p566;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/06/30
 */
class ReshapeTheMatrixTest {
	private final ReshapeTheMatrix sut = new ReshapeTheMatrix();

	@Test
	void case1() {
		int[][] actual = sut.matrixReshape(new int[][] {{1, 2}, {3, 4}}, 1, 4);
		int[][] expected = new int[][] {{1, 2, 3, 4}};

		for (int i = 0; i < actual.length; i++) {
			assertArrayEquals(expected[i], actual[i]);
		}
	}

	@Test
	void case2() {
		int[][] actual = sut.matrixReshape(new int[][] {{1, 2}, {3, 4}}, 2, 4);
		int[][] expected = new int[][] {{1, 2}, {3, 4}};

		for (int i = 0; i < actual.length; i++) {
			assertArrayEquals(expected[i], actual[i]);
		}
	}

	@Test
	void case3() {
		int[][] actual = sut.matrixReshape(new int[][] {{1, 2, 3, 4}}, 2, 2);
		int[][] expected = new int[][] {{1, 2}, {3, 4}};

		for (int i = 0; i < actual.length; i++) {
			assertArrayEquals(expected[i], actual[i]);
		}
	}

	@Test
	void case4() {
		System.out.println(25 ^ 5);
		System.out.println((25 + 5) / 2);
	}
}