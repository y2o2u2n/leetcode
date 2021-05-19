package me.y2o2u2n.p1523;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Created by JunSeok Youn on 2021-05-19
 */
class CountOddNumbersInAnIntervalRangeTest {

	@Test
	void countOdds() {
		CountOddNumbersInAnIntervalRange sut = new CountOddNumbersInAnIntervalRange();

		assertEquals(3, sut.countOdds(3, 7));
		assertEquals(4, sut.countOdds(3, 9));
		assertEquals(1, sut.countOdds(8, 10));
		assertEquals(2, sut.countOdds(8, 12));
		assertEquals(2, sut.countOdds(3, 6));
		assertEquals(3, sut.countOdds(4, 9));
	}
}