package me.y2o2u2n.common;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Created by JunSeok Youn on 2021/08/14
 */
class Solution1Test {
	@ParameterizedTest
	@CsvSource(value = {
		"50000,2,364,997",
		"999,1,362,9",
		"10000,9,334,823",
		"6547,5,329,295",
		"1,6,329,0",
		"5000,5,184,126",
		"2529,5,77,26",
		"10000,4,1,1",
	})
	void naaame(int amount, int rateOfInterest, int days, int determinedInterest) {
		Solution1 sut = new Solution1();
		int actual = sut.determinedInterest(amount, rateOfInterest, days);
		assertEquals(determinedInterest, actual);
	}

	@Test
	void case1() {
		Solution1 sut = new Solution1();
		int actual = sut.solution(
			new String[] {"01/01 2 50000", "01/03 1 999", "01/31 9 10000", "02/05 5 6547", "02/05 6 1", "06/30 5 5000",
				"10/15 5 2529", "12/30 4 10000"});
		assertEquals(87353, actual);
	}

	@Test
	void case2() {
		Solution1 sut = new Solution1();
		int actual = sut.solution(
			new String[] {"03/01 5 15000", "05/15 2 9527", "11/30 9 10000"});
		assertEquals(35349, actual);
	}
}
