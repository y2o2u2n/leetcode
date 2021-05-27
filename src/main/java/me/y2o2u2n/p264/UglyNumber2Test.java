package me.y2o2u2n.p264;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-05-27
 */
class UglyNumber2Test {

	@Test
	void nthUglyNumber() {
		UglyNumber2 sut = new UglyNumber2();

		// assertEquals(15, sut.nthUglyNumber(1352));
		assertEquals(15, sut.nthUglyNumber(11));
		assertEquals(12, sut.nthUglyNumber(10));
		assertEquals(1, sut.nthUglyNumber(1));
	}
}