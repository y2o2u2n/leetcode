package me.y2o2u2n.p1535;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/06/08
 */
class FindTheWinnerOfAnArrayGameTest {
	private final FindTheWinnerOfAnArrayGame sut = new FindTheWinnerOfAnArrayGame();

	@Test
	void case1() {
		assertEquals(5, sut.getWinner(new int[] {2, 1, 3, 5, 4, 6, 7}, 2));
	}

	@Test
	void case2() {
		assertEquals(3, sut.getWinner(new int[] {3, 2, 1}, 10));
	}

	@Test
	void case3() {
		assertEquals(9, sut.getWinner(new int[] {1, 9, 8, 2, 3, 7, 6, 4, 5}, 7));
	}

	@Test
	void case4() {
		assertEquals(99, sut.getWinner(new int[] {1, 11, 22, 33, 44, 55, 66, 77, 88, 99}, 1000000000));
	}
}