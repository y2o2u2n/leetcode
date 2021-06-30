package me.y2o2u2n.p1338;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/06/30
 */
class ReduceArraySizeToTheHalfTest {
	private final ReduceArraySizeToTheHalf sut = new ReduceArraySizeToTheHalf();

	@Test
	void case1() {
		assertEquals(2, sut.minSetSize(new int[] {3, 3, 3, 3, 5, 5, 5, 2, 2, 7}));
	}

	@Test
	void case2() {
		assertEquals(1, sut.minSetSize(new int[] {7, 7, 7, 7, 7, 7}));
	}

	@Test
	void case3() {
		assertEquals(1, sut.minSetSize(new int[] {1, 9}));
	}

	@Test
	void case4() {
		assertEquals(1, sut.minSetSize(new int[] {1000, 1000, 3, 7}));
	}

	@Test
	void case5() {
		assertEquals(5, sut.minSetSize(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
	}
}