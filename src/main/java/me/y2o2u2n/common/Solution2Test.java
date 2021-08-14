package me.y2o2u2n.common;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/08/14
 */
class Solution2Test {

	@Test
	void case1() {
		Solution2 solution2 = new Solution2();

		assertEquals(4, solution2.solution(
			new int[][] {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}
			},
			2
		));

	}

}
