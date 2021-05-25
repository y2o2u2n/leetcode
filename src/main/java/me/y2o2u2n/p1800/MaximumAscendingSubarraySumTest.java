package me.y2o2u2n.p1800;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-05-25
 */
class MaximumAscendingSubarraySumTest {

	@Test
	void maxAscendingSum() {
		MaximumAscendingSubarraySum sut = new MaximumAscendingSubarraySum();

		assertEquals(65, sut.maxAscendingSum(new int[] {10, 20, 30, 5, 10, 50}));
		assertEquals(150, sut.maxAscendingSum(new int[] {10, 20, 30, 40, 50}));
		assertEquals(33, sut.maxAscendingSum(new int[] {12, 17, 15, 13, 10, 11, 12}));
		assertEquals(19, sut.maxAscendingSum(new int[] {3, 6, 10, 1, 8, 9, 9, 8, 9}));
	}
}