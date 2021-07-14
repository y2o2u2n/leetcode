package me.y2o2u2n.p962;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaximumWidthRampTest {
	private MaximumWidthRamp sut;

	@BeforeEach
	void setUp() {
		sut = new MaximumWidthRamp();
	}

	@Test
	void case1() {
		assertEquals(4, sut.maxWidthRamp(new int[] {6, 0, 8, 2, 1, 5}));
	}

	@Test
	void case2() {
		assertEquals(7, sut.maxWidthRamp(new int[] {9, 8, 1, 0, 1, 9, 4, 0, 4, 1}));
	}

	@Test
	void case3() {
		assertEquals(0, sut.maxWidthRamp(new int[] {1, 0}));
	}

	@Test
	void case4() {
		assertEquals(1, sut.maxWidthRamp(new int[] {2, 2, 1}));
	}
}