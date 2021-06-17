package me.y2o2u2n.p322;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-06-17
 */
class CoinChangeTest {
	private final CoinChange sut = new CoinChange();

	@Test
	void case1() {
		assertEquals(3, sut.coinChange(new int[] {1, 2, 5}, 11));
	}

	@Test
	void case2() {
		assertEquals(-1, sut.coinChange(new int[] {2}, 3));
	}

	@Test
	void case3() {
		assertEquals(0, sut.coinChange(new int[] {1}, 0));
	}

	@Test
	void case4() {
		assertEquals(1, sut.coinChange(new int[] {1}, 1));
	}

	@Test
	void case5() {
		assertEquals(2, sut.coinChange(new int[] {1}, 2));
	}

	@Test
	void case6() {
		assertEquals(4, sut.coinChange(new int[] {2, 5, 10, 1}, 27));
	}

	@Test
	void case7() {
		assertEquals(2, sut.coinChange(new int[] {2, 5, 3, 6}, 10));
	}
}