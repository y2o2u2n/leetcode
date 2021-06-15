package me.y2o2u2n.p875;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021/06/15
 */
class SumOfAbsoluteDifferencesInASortedArrayTest {
	private final SumOfAbsoluteDifferencesInASortedArray sut = new SumOfAbsoluteDifferencesInASortedArray();
	
	// 0 1 3 = 4
	// 1 0 2 = 3
	// 3 2 0 = 5
	@Test
	void case1() {
		assertArrayEquals(new int[] {4, 3, 5}, sut.getSumAbsoluteDifferences(new int[] {2, 3, 5}));
	}

	// 0 3 5 7 9 = 24
	// 3 0 2 4 6 = 15
	// 5 2 0 2 4 = 13
	// 7 4 2 0 2 = 15
	// 9 6 4 2 0 = 21
	@Test
	void case2() {
		assertArrayEquals(new int[] {24, 15, 13, 15, 21}, sut.getSumAbsoluteDifferences(new int[] {1, 4, 6, 8, 10}));
	}
}