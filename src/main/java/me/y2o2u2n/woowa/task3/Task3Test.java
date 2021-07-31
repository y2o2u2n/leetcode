package me.y2o2u2n.woowa.task3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/07/31
 */
class Task3Test {

	@Test
	public void test1() {
		Task3 sut = new Task3();
		assertEquals(3, sut.solution(new int[] {3, 2, -2, 5, -3}));
		assertEquals(1, sut.solution(new int[] {1, 1, 2, -1, 2, -1}));
		assertEquals(0, sut.solution(new int[] {1, 2, 3, -4}));
	}

}