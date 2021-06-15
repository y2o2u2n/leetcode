package me.y2o2u2n.p896;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/06/15
 */
class MonotonicArrayTest {
	private final MonotonicArray sut = new MonotonicArray();

	@Test
	void case1() {
		assertTrue(sut.isMonotonic(new int[] {1, 2, 2, 3}));
	}

	@Test
	void case2() {
		assertTrue(sut.isMonotonic(new int[] {6, 5, 4, 4}));
	}

	@Test
	void case3() {
		assertFalse(sut.isMonotonic(new int[] {1, 3, 2}));
	}
}
