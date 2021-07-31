package me.y2o2u2n.woowa.task4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/07/31
 */
class Task4Test {

	@Test
	public void test() {

		assertEquals(new Task4().solution(new int[] {1, 3, 2, 1}, new int[] {4, 2, 5, 3, 2}), 2);
	}

	@Test
	public void test1() {

		assertEquals(new Task4().solution(new int[] {2, 1}, new int[] {3, 3}), -1);
	}

	@Test
	public void test3() {

		System.out.println(new Task4().solution(new int[] {3, 4, 5, 6, 7}, new int[] {1, 2, 3}));
		System.out.println(new Task4().solution(new int[] {3, 4, 5, 6, 7}, new int[] {1, 2, 2}));
		System.out.println(new Task4().solution(new int[] {1, 2, 3}, new int[] {3, 4, 5, 6, 7}));
		System.out.println(new Task4().solution(new int[] {1, 2, 2}, new int[] {3,4,5,6,7}));
	}
}