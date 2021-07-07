package me.y2o2u2n.p1461;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CheckIfAStringContainsAllBinaryCodesOfSizeKTest {
	private final CheckIfAStringContainsAllBinaryCodesOfSizeK sut = new CheckIfAStringContainsAllBinaryCodesOfSizeK();

	@Test
	void case1() {
		assertTrue(sut.hasAllCodes("00110110", 2));
	}

	@Test
	void case2() {
		assertTrue(sut.hasAllCodes("00110", 2));
	}

	@Test
	void case3() {
		assertTrue(sut.hasAllCodes("0110", 1));
	}

	@Test
	void case4() {
		assertFalse(sut.hasAllCodes("0110", 2));
	}

	@Test
	void case5() {
		assertFalse(sut.hasAllCodes("0000000001011100", 4));
	}
}