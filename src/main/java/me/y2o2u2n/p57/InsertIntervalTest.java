package me.y2o2u2n.p57;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-06-29
 */
class InsertIntervalTest {
	private final InsertInterval sut = new InsertInterval();

	@Test
	void case2() {
		int[][] actual = sut.insert(new int[][] {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[] {4, 8});
		int[][] expected = new int[][] {{1, 2}, {3, 10}, {12, 16}};

		for (int i = 0; i < expected.length; i++) {
			assertArrayEquals(expected[i], actual[i]);
		}
	}

}