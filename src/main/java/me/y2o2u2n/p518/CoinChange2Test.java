package me.y2o2u2n.p518;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoinChange2Test {
	private CoinChange2 sut;

	@BeforeEach
	void setUp() {
		sut = new CoinChange2();
	}

	@Test
	void case1() {
		assertEquals(4, sut.change(5, new int[] {1, 2, 5}));
	}

	@Test
	void case2() {
		assertEquals(0, sut.change(3, new int[] {2}));
	}

	@Test
	void case3() {
		assertEquals(1, sut.change(10, new int[] {10}));
	}

	@Test
	void case4() {
		assertEquals(1, sut.change(0, new int[] {7}));
	}

	@Test
	void case5() {
		assertEquals(12701, sut.change(500, new int[] {1, 2, 5}));
	}
}