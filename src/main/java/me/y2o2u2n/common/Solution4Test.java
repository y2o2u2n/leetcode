package me.y2o2u2n.common;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/08/14
 */
class Solution4Test {

	@Test
	void case1() {
		Solution4 solution4 = new Solution4();

		assertEquals(35, solution4.solution(
			new int[] {5, 8, 3, 7, 10, 5, 4},
			new int[][] {{1, 2}, {2, 4}, {1, 4}, {6, 5}, {3, 5}, {4, 6}},
			5
		));
	}

	@Test
	void case2() {
		Solution4 solution4 = new Solution4();

		assertEquals(13, solution4.solution(
			new int[] {5, 8},
			new int[][] {{1, 2}, {2, 1}},
			2
		));
	}
}
