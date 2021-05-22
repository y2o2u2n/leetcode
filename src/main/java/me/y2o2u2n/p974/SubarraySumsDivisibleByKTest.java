package me.y2o2u2n.p974;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-05-22
 */
class SubarraySumsDivisibleByKTest {

	@Test
	void subarraysDivByK() {
		SubarraySumsDivisibleByK sut = new SubarraySumsDivisibleByK();

		assertEquals(7, sut.subarraysDivByK(new int[] {4, 5, 0, -2, -3, 1}, 5));
	}
}