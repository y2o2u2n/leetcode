package me.y2o2u2n.common;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/08/29
 */
class Solution3Test {

	@Test
	public void case1() {
		int actual = new Solution3().solution(new int[] {1, 2, 3});
		assertEquals(1, actual);
	}

	@Test
	public void case2() {
		int actual = new Solution3().solution(new int[] {3, -1, 0, 4});
		assertEquals(2, actual);
	}

	@Test
	public void case3() {
		int actual = new Solution3().solution(new int[] {1, 2, 3, 4, 5});
		assertEquals(3, actual);
	}

	@Test
	public void case4() {
		int actual = new Solution3().solution(new int[] {5, 4, 3, 2, 1});
		assertEquals(4, actual);
	}

	@Test
	public void case5() {
		int actual = new Solution3().solution(new int[] {1, 1, 1, 1, 1});
		assertEquals(4, actual);
	}

}
