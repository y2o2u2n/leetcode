package me.y2o2u2n.common;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/08/14
 */
class Solution3Test {

	@Test
	void case1() {
		Solution3 solution3 = new Solution3();
		assertEquals(2, solution3.solution(3, new int[] {0, 1, 2}));
	}

	@Test
	void case2() {
		Solution3 solution3 = new Solution3();
		assertEquals(0, solution3.solution(3, new int[] {1, 0, 0}));
	}

	@Test
	void case3() {
		Solution3 solution3 = new Solution3();
		assertEquals(4, solution3.solution(5, new int[] {0, 2, 1, 1, 2}));
	}
}
