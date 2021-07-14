package me.y2o2u2n.p1913;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaximumProductDifferenceBetweenTwoPairsTest {
	private MaximumProductDifferenceBetweenTwoPairs sut;

	@BeforeEach
	void setUp() {
		sut = new MaximumProductDifferenceBetweenTwoPairs();
	}

	@Test
	void case1() {
		assertEquals(34, sut.maxProductDifference(new int[] {5, 6, 2, 7, 4}));
	}

	@Test
	void case2() {
		assertEquals(64, sut.maxProductDifference(new int[] {4, 2, 5, 9, 7, 4, 8}));
	}
}