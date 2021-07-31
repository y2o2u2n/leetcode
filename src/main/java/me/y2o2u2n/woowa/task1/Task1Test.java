package me.y2o2u2n.woowa.task1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/07/31
 */
class Task1Test {

	@Test
	void case1() {
		assertEquals(new Task1().solution(3, 2, new int[] {2,1,1,0,1}), "11100,10001");
	}

	@Test
	void case2() {
		assertEquals(new Task1().solution(2, 3, new int[] {0,0,1,1,2}), "IMPOSSIBLE");
	}

	@Test
	void case3() {
		assertEquals(new Task1().solution(2, 2, new int[] {2,0,2,0}), "1010,1010");
	}

}