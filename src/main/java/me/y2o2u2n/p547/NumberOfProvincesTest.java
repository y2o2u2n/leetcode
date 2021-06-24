package me.y2o2u2n.p547;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-06-24
 */
class NumberOfProvincesTest {
	private final NumberOfProvinces sut = new NumberOfProvinces();

	@Test
	void case1() {
		assertEquals(2, sut.findCircleNum(new int[][] {
			{1, 1, 0},
			{1, 1, 0},
			{0, 0, 1}
		}));
	}

	@Test
	void case2() {
		assertEquals(3, sut.findCircleNum(new int[][] {
			{1, 0, 0},
			{0, 1, 0},
			{0, 0, 1}
		}));
	}
}