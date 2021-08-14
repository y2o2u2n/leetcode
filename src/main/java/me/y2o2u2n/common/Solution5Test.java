package me.y2o2u2n.common;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/08/14
 */
class Solution5Test {

	@Test
	void case1() {
		Solution5 solution5 = new Solution5();

		assertArrayEquals(new int[] {5, 7, 3, 1, 3, 4, 3, 1, 0, 0},
			solution5.solution(new int[] {5, 3, 7, 9, 5, 2, 4, 9, 10, 6}));
	}

	@Test
	void case2() {
		Solution5 solution5 = new Solution5();

		assertArrayEquals(
			new int[] {0, 1, 2, 3, 4, 3, 2, 1, 0}, solution5.solution(new int[] {5, 4, 3, 2, 1, 2, 3, 4, 5}));
	}

}
