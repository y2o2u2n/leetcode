package me.y2o2u2n.p179;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-06-24
 */
class LargestNumberTest {
	private final LargestNumber sut = new LargestNumber();

	@Test
	void case1() {
		assertEquals("210", sut.largestNumber(new int[] {10, 2}));
	}

	@Test
	void case2() {
		assertEquals("9534330", sut.largestNumber(new int[] {3, 30, 34, 5, 9}));
	}

	@Test
	void case3() {
		assertEquals("1", sut.largestNumber(new int[] {1}));
	}

	@Test
	void case4() {
		assertEquals("10", sut.largestNumber(new int[] {10}));
	}

	@Test
	void case5() {
		assertEquals("83088308830", sut.largestNumber(new int[] {8308, 8308, 830}));
	}

}